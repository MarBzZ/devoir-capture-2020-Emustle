<?php
require "connexion.php";

$paramAnnee = $_GET["annee"];

$SQL_ANNEE = "SELECT AVG(mesure) as moyenne, MAX(mesure) as max, MIN(mesure) as min
            FROM precipitation
            WHERE moment BETWEEN ':annee-01-01 00:00:01' AND ':annee-12-31 23:59:59'";
$requeteAnnee = $connexion->prepare($SQL_ANNEE);
$requeteAnnee->bindParam(":annee", $paramAnnee);
$requeteAnnee->execute();
$annee = $requeteAnnee->fetch();


$SQL_LISTE_MOIS = "SELECT date_part('month', moment) as mois, AVG(mesure) as moyenne, MAX(mesure) as max, MIN(mesure) as min
            FROM precipitation
            GROUP BY mois
            ORDER BY mois ASC";
$requeteListeMois = $connexion->prepare($SQL_LISTE_MOIS);
$requeteListeMois->execute();
$listeMois = $requeteListeMois->fetchAll();

?> 

<?xml version="1.0" encoding="UTF-8"?>
<precipitations>
	<precipitation>
		<mois>
            <?php
            foreach($listeMois as $mois)
            {
            ?>
            <mois-<?php echo $mois['mois']?>>
                <moyenne><?php echo $mois['moyenne']?></moyenne>
                <min><?php echo round($mois['min'], 1)?></min>
                <max><?php echo round($mois['max'], 1)?></max>
            </mois-<?php echo $mois['mois']?>>
            <?php
            }
            ?>
        </mois>
		<moyenne><?php echo $annee['moyenne']?></moyenne>
		<min><?php echo round($annee['min'], 1)?></min>
		<max><?php echo round($annee['max'], 1)?></max>
	</precipitation>
</precipitations>