<?php

class DbHandler {
 
    private $conn;
 
    function __construct() {
        require_once dirname(__FILE__) . './DbConnect.php';
        // opening db connection
        $db = new DbConnect();
        $this->conn = $db->connect();
    }
 
	/**
	* Fetching food
	*/
	public function getLokasi(){
		$stmt = $this->conn->prepare("SELECT id, nama_makanan, asal_makanan, lokasi FROM lokasi ORDER BY id ASC");
		
		$stmt->execute();
		$tasks = $stmt->get_result();
        $stmt->close();
		
        return $tasks;		

	}


	public function getLokasiPerasal_makanan($asal_makanan) {
		$stmt = $this->conn->prepare("SELECT id, nama_makanan, asal_makanan, lokasi FROM lokasi WHERE asal_makanan = ? ORDER BY id ASC");
		$stmt->bind_param("s", $asal_makanan);
		$stmt->execute();

		$tasks = $stmt->get_result();
		$stmt->close();

		return $tasks;
	}

	public function getSurvey(){
		$stmt = $this->conn->prepare("SELECT id_survey, nama, persen FROM survey ORDER BY id_survey ASC");
		
		$stmt->execute();
		$tasks = $stmt->get_result();
        $stmt->close();
		
        return $tasks;		

	}

	public function getSurveyPerpersen($persen) {
		$stmt = $this->conn->prepare("SELECT id_survey, nama, persen FROM survey WHERE persen = ? ORDER BY id_survey ASC");
		$stmt->bind_param("s", $persen);
		$stmt->execute();

		$tasks = $stmt->get_result();
		$stmt->close();

		return $tasks;
	}

	function verifyRequiredParams($required_fields) {
		$error = false;
		$error_fields = "";
		$request_params = array();
		$request_params = $_REQUEST;
		//Handling PUT request params
		if ($_SERVER['REQUEST_METHOD'] == 'PUT') {
			$app = \Slim\Slim::getInstance();
			parse_str($app->request()->getBody(), $request_params);
		}
		foreach ($required_fields as $field) {
			if (!isset($request_params[$field]) || strlen(trim($request_params[$field])) <= 0) {
				$error = true;
				$error_fields .= $field . ', ';
			}
		}

		if ($error) {
			//Required field(s) are missing or empty
			//echo error json and stop the app
			$response = array();
			$pp = \Slim\Slim::getInstance();
			$response["error"] = true;
			$response["message"] = 'Required field(s) ' . substr($error_fields, 0, -2) . ' is missing or empty';
			echoRespnse(400, $response);
			$app->stop();
		}
	}
}
	
 
?>