<?php
    $codPelicula = $_POST['codPelicula'];
    $pdo = new PDO('mysql:host=localhost; dbname=videoclub','root','',array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
    $sentencia = $pdo->prepare("select * from peliculas where codPelicula = :codPelicula ");
    $sentencia->bindParam(":codPelicula",$codPelicula);
    $sentencia->execute();
    $registros = $sentencia->fetchAll();

    echo "<table style='border-collapse:collapse'>";
    foreach ($registros as $registro) {
?>
    <tr>
        <td style="border: 1px solid black">
            <?php echo $registro['codpelicula']; ?>
        </td>
        <td style="border: 1px solid black">
            <?php echo $registro['titulo']; ?>
        </td>
        <td style="border: 1px solid black">
            <?php echo $registro['tema']; ?>
        </td>
        <td style="border: 1px solid black">
            <?php echo $registro['duracion']; ?>
        </td>
        <td style="border: 1px solid black">
            <?php echo $registro['precio']; ?>
        </td>
    </tr>
<?php
    }
    echo "</table>";
?>