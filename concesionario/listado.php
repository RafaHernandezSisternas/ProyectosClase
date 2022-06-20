<?php
	$pdo = new PDO('mysql:host=localhost;dbname=concesionario', 'root', '',
	array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));

	echo "Conexión realizada con éxito<br>";
	
	$sentencia = $pdo->query("select * from vehiculos");
	
	$sentencia->execute();
 
	$resultado = $sentencia->fetchAll();
	
	echo "<table style='border-collapse:collapse'>";
	foreach($resultado as $registro){
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
