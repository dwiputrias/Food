	<?php 
 require_once 'koneksi.php';

 if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
 	$id = $_POST['id'];
 	$nama = $_POST['nama'];
 	$harga = $_POST['harga'];
 	$deskripsi = $_POST['deskripsi'];

 	$query = "UPDATE  food SET nama = '$nama',harga = '$harga', deskripsi = '$deskripsi' WHERE id='$id'";

 	$exeQuery = mysqli_query($konek, $query); 

 	echo ($exeQuery) ? json_encode(array('kode' =>1, 'pesan' => 'data berhasil update')) :  json_encode(array('kode' =>2, 'pesan' => 'data gagal diupdate'));
 }
 else
 {
 	 echo json_encode(array('kode' =>101, 'pesan' => 'request tidak valid'));
 }

 ?>