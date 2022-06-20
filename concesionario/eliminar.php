<?php
	$codVehiculo = $_POST['codVehiculo'];
	$pdo = new PDO('mysql:host=localhost;dbname=concesionario', 'root', '',
	array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
	$sentencia = $pdo->prepare("delete from vehiculos where codvehiculo = :codVehiculo");
	$sentencia->bindParam(":codVehiculo", $codVehiculo);
	$sentencia->execute();
	if($sentencia->rowCount()==0){
		echo "Vehiculo no existe!!";
	} else {
		echo "Vehiculo eliminado";
	}	
?>