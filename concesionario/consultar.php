<?php
	$codVehiculo = $_POST['codVehiculo'];
	$pdo = new PDO('mysql:host=localhost;dbname=concesionario', 'root', '',
	array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
	$sentencia = $pdo->prepare("select * from vehiculos where codvehiculo = :codvehiculo");
	$sentencia->bindParam(":codvehiculo", $codVehiculo);
	$sentencia->execute();
	$registros = $sentencia->fetchAll();
	
	echo "<table style='border-collapse:collapse'>";
	foreach($registros as $registro){
	?>
		<tr>
			<td style="border: 1px solid black"><?php echo $registro['codvehiculo'];?></td>
			<td style="border: 1px solid black"><?php echo $registro['marca'];?></td>
			<td style="border: 1px solid black"><?php echo $registro['modelo'];?></td>
			<td style="border: 1px solid black"><?php echo $registro['tipo'];?></td>
			<td style="border: 1px solid black"><?php echo $registro['color'];?></td>
			<td style="border: 1px solid black"><?php echo $registro['motor'];?></td>
			<td style="border: 1px solid black"><?php echo $registro['cilindrada'];?></td>
			<td style="border: 1px solid black"><?php echo $registro['fecha'];?></td>
			<td style="border: 1px solid black"><?php echo $registro['matricula'];?></td>
			<td style="border: 1px solid black"><?php echo $registro['extras'];?></td>
			<td style="border: 1px solid black"><?php echo $registro['precio'];?></td>				
		</tr>
	<?php			
	}
	echo "</table>";
	?>
