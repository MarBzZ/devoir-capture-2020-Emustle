<?php

require "connexion.php";

$paramAnnee = filter_var($_GET["annee"], FILTER_VALIDATE_INT);

if(!empty($paramAnnee))
{

    $SQL_ANNEE = "SELECT AVG(mesure) as moyenne, MAX(mesure) as max, MIN(mesure) as min
                FROM precipitation
                WHERE date_part('year', moment) = :annee";
    $requeteAnnee = $connexion->prepare($SQL_ANNEE);
    $requeteAnnee->bindParam(":annee", $paramAnnee);
    $requeteAnnee->execute();
    $annee = $requeteAnnee->fetch();

    $SQL_LISTE_MOIS = "SELECT date_part('month', moment) as mois, AVG(mesure) as moyenne, MAX(mesure) as max, MIN(mesure) as min
                FROM precipitation
                WHERE date_part('year', moment) = :annee
                GROUP BY mois
                ORDER BY mois ASC";
    $requeteListeMois = $connexion->prepare($SQL_LISTE_MOIS);
    $requeteListeMois->bindParam(":annee", $paramAnnee);
    $requeteListeMois->execute();
    $listeMois = $requeteListeMois->fetchAll();
}

header("Content-Type: text/xml");
echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<precipitations>
<?php
foreach($listeMois as $mois)
{
?>
    <precipitation>
		<mois><?php echo $mois['mois'];?></mois>
        <moyenne><?php echo  number_format($mois['moyenne'],1);?></moyenne>
        <min><?php echo  number_format($mois['min'],1);?></min>
        <max><?php echo  number_format($mois['max'],1);?></max>
    </precipitation>
<?php
}
?>
    <moyenne><?php echo  number_format($annee['moyenne'],1);?></moyenne>
	<min><?php echo  number_format($annee['min'],1);?></min>
	<max><?php echo  number_format($annee['max'],1);?></max>
</precipitations>
