<?php
include "PrecipitationDAO.php";

$paramJour = filter_var($_GET['jour'], FILTER_VALIDATE_INT);
$paramMois = filter_var($_GET['mois'], FILTER_VALIDATE_INT);
$paramAnnee = filter_var($_GET["annee"], FILTER_VALIDATE_INT);

if(!empty($paramAnnee) && !empty($paramMois) && !empty($paramJour))
{
    $jour = PrecipitationDAO::listerStatsJour($paramAnnee, $paramMois, $paramJour);
    $listeHeure = PrecipitationDAO::listerHeures($paramAnnee, $paramMois, $paramJour);
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
