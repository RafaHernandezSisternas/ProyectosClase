<?php
    $codPelicula = $_POST['codPelicula'];
    $pdo = new PDO('mysql:host=localhost; dbname=videoclub','root','',array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
    $sentencia = $pdo->prepare("delete from peliculas where codPelicula = :codPelicula ");
    $sentencia->bindParam(":codPelicula",$codPelicula);
    $sentencia->execute();
    if($sentencia->rowCount()==0){
        echo "Pelicula no existe!!";
    } else {
        echo "Pelicula eliminada con exito";
    }


?>