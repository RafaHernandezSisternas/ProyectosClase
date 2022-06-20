<?php
	$codVehiculo = $_POST['codVehiculo'];
	$pdo = new PDO('mysql:host=localhost;dbname=concesionario', 'root', '',
	array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
	$sentencia = $pdo->prepare("select * from vehiculos where codvehiculo = :codVehiculo");
	$sentencia->bindParam(":codVehiculo", $codVehiculo);
	$sentencia->execute();
	$registros = $sentencia->fetchAll();
	if(count($registros)==0){
		echo "Vehiculo NO existe";
		exit();
	}
	$titulo = $registros[0]['titulo'];
	$tema = $registros[0]['tema'];
	$duracion = $registros[0]['duracion'];
	$precio = $registros[0]['precio'];	
?>
<html>
	<head>
		<title>Alta Pelicula</title>
		<meta charset="utf-8">
	</head>
	<body>
		<form method="POST" action="actualizar.php">
			Cod.Pelicula: 
			<input type="text" name="codPelicula" 
				value="<?php echo $codPelicula; ?>" readonly><br>
			Titulo: 
			<input type="text" name="titulo"
				value="<?php echo $titulo; ?>"><br>
			Tema: 
			<input type="text" name="tema"
				value="<?php echo $tema; ?>"><br>
			Duración: 
			<input type="text" name="duracion"
				value="<?php echo $duracion; ?>"><br>
			Precio: 
			<input type="text" name="precio"
				value="<?php echo $precio; ?>"><br>
			<input type="submit" name="enviar" value="Enviar">
		</form>
	</body>
</html>