<?php
	$codVehiculo = $_POST['codVehiculo'];
	$marca = $_POST['marca'];
	$modelo = $_POST['modelo'];
	$tipo = $_POST['tipo'];
	$color = $_POST['color'];
	$motor = $_POST['motor'];
	$cilindrada = $_POST['cilindrada'];
	$fecha = $_POST['fecha'];
	$matricula = $_POST['matricula'];
	$extras = $_POST['extras'];
	$precio = $_POST['precio'];
	
	$pdo = new PDO('mysql:host=localhost;dbname=concesionario', 'root', '',	array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
	
	$sentencia=$pdo->prepare("insert into vehiculos values(:codVehiculo, :marca, :modelo, :tipo, :color, :motor, :cilindrada, :fecha, :matricula, :extras, :precio)");
	$sentencia->bindParam(':codVehiculo',$codVehiculo);
	$sentencia->bindParam(':marca',$marca);
	$sentencia->bindParam(':modelo',$modelo);
	$sentencia->bindParam(':tipo',$tipo);
	$sentencia->bindParam(':color',$color);
	$sentencia->bindParam(':motor',$motor);
	$sentencia->bindParam(':cilindrada',$cilindrada);
	$sentencia->bindParam(':fecha',$fecha);
	$sentencia->bindParam(':matricula',$matricula);
	$sentencia->bindParam(':extras',$extras);
	$sentencia->bindParam(':precio',$precio);
	
	$sentencia->execute();
	
	$numRegistros = $sentencia->rowCount();
	if($numRegistros>0){
		echo "Vehiculo Insertado correctamente";
	} else {
		echo "Vehiculo NO insertado";
	
	}
?>
