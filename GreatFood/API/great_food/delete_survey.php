<?php 
 require_once 'koneksi.php';

 if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
 	$id_survey = $_POST['id_survey'];

 	$query = "DELETE FROM survey WHERE id_survey ='$id_survey'";

 	$exeQuery = mysqli_query($konek, $query); 

 	echo ($exeQuery) ? json_encode(array('kode' =>1, 'pesan' => 'berhasil Menghapus data')) :  json_encode(array('kode' =>2, 'pesan' => 'data gagal dihapus'));
 }
 else
 {
 	 echo json_encode(array('kode' =>101, 'pesan' => 'request tidak valid'));
 }

 ?>