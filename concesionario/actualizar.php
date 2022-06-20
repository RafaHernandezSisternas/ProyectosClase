<?php
	$codPelicula = $_POST['codPelicula'];
	$titulo = $_POST['titulo'];
	$tema = $_POST['tema'];
	$duracion = $_POST['duracion'];
	$precio = $_POST['precio'];
	
	$pdo = new PDO('mysql:host=localhost;dbname=videoclub', 'root', '',	array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
	
	$sentencia=$pdo->prepare("update peliculas set titulo=:titulo, tema=:tema, duracion=:duracion, precio=:precio where codpelicula=:codPelicula");
	$sentencia->bindParam(':codPelicula',$codPelicula);
	$sentencia->bindParam(':titulo',$titulo);
	$sentencia->bindParam(':tema',$tema);
	$sentencia->bindParam(':duracion',$duracion);
	$sentencia->bindParam(':precio',$precio);
	
	$sentencia->execute();
	
	$numRegistros = $sentencia->rowCount();
	if($numRegistros>0){
		echo "Pelicula Actualizada correctamente";
	} else {
		echo "Pelicula NO Actualizada";
	
	}
?>