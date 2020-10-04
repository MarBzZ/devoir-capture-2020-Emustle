<?php
require "connexion.php";

$paramJour = filter_var($_GET['jour'], FILTER_VALIDATE_INT);
$paramMois = filter_var($_GET['mois'], FILTER_VALIDATE_INT);
$paramAnnee = filter_var($_GET["annee"], FILTER_VALIDATE_INT);

if(!empty($paramAnnee) && !empty($paramMois) && !empty($paramJour))
{
    $SQL_JOUR = "SELECT AVG(mesure) as moyenne, MAX(mesure) as max, MIN(mesure) as min
                FROM precipitation
                WHERE date_part('day', moment) = :jour
                AND date_part('month', moment) = :mois
                AND date_part('year', moment) = :annee";
    $requeteJour = $connexion->prepare($SQL_JOUR);
    $requeteJour->bindParam(":jour", $paramJour);
    $requeteJour->bindParam(":mois", $paramMois);
    $requeteJour->bindParam(":annee", $paramAnnee);
    $requeteJour->execute();
    $jour = $requeteJour->fetch();


    $SQL_LISTE_HEURE = "SELECT date_part('hour', moment) as heure, AVG(mesure) as moyenne, MAX(mesure) as max, MIN(mesure) as min
                FROM precipitation
                WHERE date_part('day', moment) = :jour
                AND date_part('month', moment) = :mois
                AND date_part('year', moment) = :annee
                GROUP BY heure
                ORDER BY heure ASC";
    $requeteListeHeure = $connexion->prepare($SQL_LISTE_HEURE);
    $requeteListeHeure->bindParam(":jour", $paramJour);
    $requeteListeHeure->bindParam(":mois", $paramMois);
    $requeteListeHeure->bindParam(":annee", $paramAnnee);
    $requeteListeHeure->execute();
    $listeHeure = $requeteListeHeure->fetchAll();
}

header("Content-type: text/xml");
echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<precipitations>
<?php
foreach($listeHeure as $heure)
{
?>
    <precipitation>
		<heure><?php echo $heure['heure'];?></heure>
        <moyenne><?php echo  number_format($heure['moyenne'],1);?></moyenne>
        <min><?php echo  number_format($heure['min'],1);?></min>
        <max><?php echo  number_format($heure['max'],1);?></max>
    </precipitation>
<?php
}
?>
    <moyenne><?php echo  number_format($jour['moyenne'],1);?></moyenne>
	<min><?php echo  number_format($jour['min'],1);?></min>
	<max><?php echo  number_format($jour['max'],1);?></max>
</precipitations>
