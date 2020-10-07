<?php
include "PrecipitationDAO.php";

$paramMois = filter_var($_GET['mois'], FILTER_VALIDATE_INT);
$paramAnnee = filter_var($_GET["annee"], FILTER_VALIDATE_INT);

if(!empty($paramAnnee) && !empty($paramMois))
{    
    $mois = PrecipitationDAO::listerStatsMois($paramAnnee, $paramMois);
    $listeJour = PrecipitationDAO::listerJours($paramAnnee, $paramMois);
}

header("Content-type: text/xml");
echo '<?xml version="1.0" encoding="UTF-8"?>';
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
