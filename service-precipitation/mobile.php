<?php
include "PrecipitationDAO.php";

$paramMois = filter_var($_GET['mois'], FILTER_VALIDATE_INT);
$paramAnnee = filter_var($_GET["annee"], FILTER_VALIDATE_INT);

//requete SQL pour la base de donnee pour la mesure actuelle
if(!empty($paramAnnee) && !empty($paramMois))
{
//requete SQL pour la base de donnee pour la mesure actuelle
$actuelle = PrecipitationDAO::listerStatActuelle();

//requete SQL pour la base de donnee pour la moyenne de la journee
$jour = PrecipitationDAO::listerStatJour();

//requete SQL pour la base de donnee pour la moyenne de l'annee
$annee = PrecipitationDAO::listerStatsAnnee($paramAnnee);
}

header("Content-Type:text/xml");?>
<?xml version="1.0" encoding="UTF-8"?>
<precipitations>
    <precipitation>
        <mesure_actuelle><?php echo $actuelle['mesure']?></mesure_actuelle>
        <moyenne_jour><?php echo $jour['moyenne']?></moyenne_jour>
        <moyenne_annee><?php echo $annee['moyenne']?></moyenne_annee>
    </precipitation>
</precipitations>