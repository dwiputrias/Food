<?php
 
require_once 'include/DbHandler.php';
require_once 'include/PassHash.php';
require 'libs/Slim/Slim.php';

\Slim\Slim::registerAutoloader();

$app = new \Slim\Slim();

/**
 * ----------- METHODS WITHOUT AUTHENTICATION ---------------------------------
 */
 
//lokasi
$app->post('/lokasi', function () {
	$response = array();

	$db = new DbHandler();

	// fetching all lokasi
	$result = $db->getLokasi();
		//print_r($result);


	$response["error"] = false;
	$response["lokasi"] = array();

	// looping through result and preparing materi array
	while ($strData = $result->fetch_assoc()) {
	    $tmp = array();
	    $tmp["id"] = utf8_encode($strData["id"]);
	    $tmp["nama_makanan"] = utf8_encode($strData["nama_makanan"]);
	    $tmp["asal_makanan"] = utf8_encode($strData["asal_makanan"]);
	    $tmp["lokasi"] = utf8_encode($strData["lokasi"]);

	    array_push($response["lokasi"], $tmp);
	}

	echoRespnse(200, $response);
});

$app->post('/lokasiperasal_makanan', function() use ($app) {
		// //check for required params
		// verifyRequiredParams(array('asal_makanan'));

		$response = array();
		//reading post params
		$asal_makanan = $app->request->post('asal_makanan');

		$db = new DbHandler();

		//fetching all food per asal_makanan
		$result = $db->getLokasiPerasal_makanan($asal_makanan);
		$response["error"] = false;
		$response["lokasiperasal_makanan"] = array();

		// looping through result and preparing materi array
		while ($strData = $result->fetch_assoc()) {
		    $tmp = array();
		    $tmp["id"] = utf8_encode($strData["id"]);
		    $tmp["nama_makanan"] = utf8_encode($strData["nama_makanan"]);
		    $tmp["asal_makanan"] = utf8_encode($strData["asal_makanan"]);
		    $tmp["lokasi"] = utf8_encode($strData["lokasi"]);

	    	array_push($response["lokasiperasal_makanan"], $tmp);
	}

		echoRespnse(200, $response);
	});


//survey
$app->post('/survey', function () {
	$response = array();

	$db = new DbHandler();

	// fetching all survey
	$result = $db->getSurvey();
		//print_r($result);


	$response["error"] = false;
	$response["survey"] = array();

	// looping through result and preparing materi array
	while ($strData = $result->fetch_assoc()) {
	    $tmp = array();
	    $tmp["id_survey"] = utf8_encode($strData["id_survey"]);
	    $tmp["nama"] = utf8_encode($strData["nama"]);
	    $tmp["persen"] = utf8_encode($strData["persen"]);

	    array_push($response["survey"], $tmp);
	}

	echoRespnse(200, $response);
});

$app->post('/surveyperpersen', function() use ($app) {
		// //check for required params
		// verifyRequiredParams(array('persen'));

		$response = array();
		//reading post params
		$persen= $app->request->post('persen');

		$db = new DbHandler();

		//fetching all food per asal_makanan
		$result = $db->getSurveyPerpersen($persen);
		$response["error"] = false;
		$response["surveyperpersen"] = array();

		// looping through result and preparing materi array
		while ($strData = $result->fetch_assoc()) {
		    $tmp = array();
		    $tmp["id_survey"] = utf8_encode($strData["id_survey"]);
		    $tmp["nama"] = utf8_encode($strData["nama"]);
		    $tmp["persen"] = utf8_encode($strData["persen"]);

	    	array_push($response["surveyperpersen"], $tmp);
	}

		echoRespnse(200, $response);
	});



/**
 * Echoing json response to client
 * @param String $status_code Http response code
 * @param Int $response Json response
 * Daftar response
 * 200	OK
 * 201	Created
 * 304	Not Modified
 * 400	Bad Request
 * 401	Unauthorized
 * 403	Forbidden
 * 404	Not Found
 * 422	Unprocessable Entity
 * 500	Internal Server Error
 */
function echoRespnse($status_code, $response) {
    $app = \Slim\Slim::getInstance();
    // Http response code
    $app->status($status_code);

    // setting response content type to json
    $app->contentType('application/json');

	//print_r($response);
    echo json_encode($response);
}


$app->run();
?>