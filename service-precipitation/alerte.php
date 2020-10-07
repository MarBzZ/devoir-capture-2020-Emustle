<?php
include "PrecipitationDAO.php";

$paramAnnee = filter_var($_GET["annee"], FILTER_VALIDATE_INT);

if(!empty($paramAnnee))
{
//requete SQL pour la base de donnee pour la mesure actuelle
$actuelle = PrecipitationDAO::listerStatActuelle();

//requete SQL pour la base de donnee pour la moyenne de la journee
$jour = PrecipitationDAO::listerStatJour();

//requete SQL pour la base de donnee pour la moyenne de l'annee
$annee = PrecipitationDAO::listerStatsAnnee($paramAnnee);
}

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
