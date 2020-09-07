	<?php 
 require_once 'koneksi.php';

 if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
 	$id_survey = $_POST['id_survey'];
 	$nama = $_POST['nama'];
 	$persen = $_POST['persen'];

 	$query = "UPDATE persen SET nama = '$nama',persen = '$persen' WHERE id_survey='$id_survey'";

 	$exeQuery = mysqli_query($konek, $query); 

 	echo ($exeQuery) ? json_encode(array('kode' =>1, 'pesan' => 'data berhasil update')) :  json_encode(array('kode' =>2, 'pesan' => 'data gagal diupdate'));
 }
 else
 {
 	 echo json_encode(array('kode' =>101, 'pesan' => 'request tidak valid'));
 }

 ?>