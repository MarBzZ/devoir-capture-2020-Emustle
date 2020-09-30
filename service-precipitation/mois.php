<?php
require "connexion.php";

$paramMois = $_GET['mois'];

$SQL_MOIS = "SELECT AVG(mesure) as moyenne, MAX(mesure) as max, MIN(mesure) as min
            FROM precipitation
            WHERE date_part('month', moment) = :mois";

$requeteMois = $connexion->prepare($SQL_MOIS);
$requeteMois->bindParam(":mois", $paramMois);
$requeteMois->execute();
$mois = $requeteMois->fetch();


$SQL_LISTE_JOUR = "SELECT date_part('day', moment) as jour, AVG(mesure) as moyenne, MAX(mesure) as max, MIN(mesure) as min
            FROM precipitation
            WHERE date_part('month', moment) = :mois
            GROUP BY jour
            ORDER BY jour ASC";
$requeteListeJour = $connexion->prepare($SQL_LISTE_JOUR);
$requeteListeJour->bindParam(":mois", $paramMois);
$requeteListeJour->execute();
$listeJour = $requeteListeJour->fetchAll();

?> 

<?xml version="1.0" encoding="UTF-8"?>
<precipitations>
	<precipitation>
		<jour>
            <?php
            foreach($listeJour as $jour)
            {
            ?>
            <jour-<?php echo $jour['jour']?>>
                <moyenne><?php echo $jour['moyenne']?></moyenne>
                <min><?php echo $jour['min']?></min>
                <max><?php echo $jour['max']?></max>
            </jour-<?php echo $jour['jour']?>>
            <?php
            }
            ?>
        </jour>
		<moyenne><?php echo $mois['moyenne']?></moyenne>
		<min><?php echo $mois['min']?></min>
		<max><?php echo $mois['max']?></max>
	</precipitation>
</precipitations>