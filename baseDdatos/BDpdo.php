<meta charset="utf-8">
<?php
    $pdo = new PDO('mysql:host=localhost;dbname=videoclub','root','');
    echo "Conexión realizada con exito <br>";

    $sentencia = $pdo->query("select * from peliculas");

    $sentencia->execute();

    $resultado = $sentencia->fetchAll();

    echo "<table style='border-collapse:collapse'>";
    foreach ($resultado as $registro) {
?>
    <tr>
        <td style="border: 1px solid black">
            <?php
                echo $registro['codpelicula'];
            ?>
        </td>
        <td style="border: 1px solid black">
            <?php
                echo $registro['titulo'];
            ?>
        </td>
        <td style="border: 1px solid black">
            <?php
                echo $registro['tema'];
            ?>
        </td>
        <td style="border: 1px solid black">
            <?php
                echo $registro['duracion'];
            ?>
        </td>
        <td style="border: 1px solid black">
            <?php
                echo $registro['precio'];
            ?>
        </td>
    </tr>
<?php
    }
    echo "</table>";
?>