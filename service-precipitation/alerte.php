<?php
require "./connexion.php";

$paramAnnee = $_GET["annee"];
//requete SQL pour la base de donnee pour la mesure actuelle
$REQUEST_ACTUELLE = "SELECT mesure FROM precipitation WHERE moment = (SELECT MIN(moment) FROM precipitation)"; 
$temp = $connexion->prepare($REQUEST_ACTUELLE);
$temp->execute();
$actuelle = $temp->fetch();

//requete SQL pour la base de donnee pour la moyenne de la journee
$REQUEST_JOUR = "SELECT AVG(mesure) as moyenne FROM precipitation WHERE moment <= now()";
$temp = $connexion->prepare($REQUEST_JOUR);
$temp->execute();
$jour = $temp->fetch();

//requete SQL pour la base de donnee pour la moyenne de l'annee
$REQUEST_ANNEE = "SELECT AVG(mesure) as moyenne FROM precipitation WHERE date_part('year', moment) = :annee"; 
$temp = $connexion->prepare($REQUEST_ANNEE);
$temp->bindParam(":annee", $paramAnnee);
$temp->execute();
$annee = $temp->fetch();

$seuil = 4;

header("Content-Type:text/xml");?>
<?xml version="1.0" encoding="UTF-8"?>
<precipitations>
    <precipitation>
        <mesure_actuelle><?php echo $actuelle['mesure']?></mesure_actuelle>
        <?php 
            if($actuelle > $seuil)
            {
        ?>
        <alerte>Temperature surperieur au seuil</alerte>
        <temp_fautive><?php echo $actuelle['mesure']?></temp_fautive>
        <?php
            }
        ?>
        <moyenne_jour><?php echo $jour['moyenne']?></moyenne_jour>
        <moyenne_annee><?php echo $annee['moyenne']?></moyenne_annee>
    </precipitation>
</precipitations>