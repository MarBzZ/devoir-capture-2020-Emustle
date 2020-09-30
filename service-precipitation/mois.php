<?php
header("Content-type: text/xml");
echo '<?xml version="1.0" encoding="UTF-8"?>';

require "connexion.php";
$paramMois = $_GET['mois'];
$paramAnnee = $_GET["annee"];

$SQL_MOIS = "SELECT AVG(mesure) as moyenne, MAX(mesure) as max, MIN(mesure) as min
            FROM precipitation
            WHERE date_part('month', moment) = :mois
            AND date_part('year', moment) = :annee";

$requeteMois = $connexion->prepare($SQL_MOIS);
$requeteMois->bindParam(":mois", $paramMois);
$requeteMois->bindParam(":annee", $paramAnnee);
$requeteMois->execute();
$mois = $requeteMois->fetch();


$SQL_LISTE_JOUR = "SELECT date_part('day', moment) as jour, AVG(mesure) as moyenne, MAX(mesure) as max, MIN(mesure) as min
            FROM precipitation
            WHERE date_part('month', moment) = :mois
            AND date_part('year', moment) = :annee
            GROUP BY jour
            ORDER BY jour ASC";
$requeteListeJour = $connexion->prepare($SQL_LISTE_JOUR);
$requeteListeJour->bindParam(":mois", $paramMois);
$requeteListeJour->bindParam(":annee", $paramAnnee);
$requeteListeJour->execute();
$listeJour = $requeteListeJour->fetchAll();

?> 
<precipitations>
<?php
foreach($listeJour as $jour)
{
?>
    <precipitation>
		<jour><?php echo $jour['jour'];?></jour>
        <moyenne><?php echo  number_format($jour['moyenne'],1);?></moyenne>
        <min><?php echo  number_format($jour['min'],1);?></min>
        <max><?php echo  number_format($jour['max'],1);?></max>
    </precipitation>
<?php
}
?>
    <moyenne><?php echo  number_format($mois['moyenne'],1);?></moyenne>
	<min><?php echo  number_format($mois['min'],1);?></min>
	<max><?php echo  number_format($mois['max'],1);?></max>
</precipitations>