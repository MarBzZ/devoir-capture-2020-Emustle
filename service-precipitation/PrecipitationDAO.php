<?php

require "BaseDeDonnees.php";

class PrecipitationDAO
{
    public static function listerStatsAnnee($paramAnnee)
    {
        $SQL_ANNEE = "SELECT AVG(mesure) as moyenne, MAX(mesure) as max, MIN(mesure) as min
                FROM precipitation
                WHERE date_part('year', moment) = :annee";
        $requeteAnnee = BaseDeDonnees::getConnection()->prepare($SQL_ANNEE);
        $requeteAnnee->bindParam(":annee", $paramAnnee);
        $requeteAnnee->execute();
        $annee = $requeteAnnee->fetch();

        return $annee;
    }

    public static function listerStatsMois($paramAnnee, $paramMois)
    {
        $SQL_MOIS = "SELECT AVG(mesure) as moyenne, MAX(mesure) as max, MIN(mesure) as min
                FROM precipitation
                WHERE date_part('year', moment) = :annee
                AND date_part('month', moment) = :mois";
        $requeteMois = BaseDeDonnees::getConnection()->prepare($SQL_MOIS);
        $requeteMois->bindParam(":annee", $paramAnnee);
        $requeteMois->bindParam(":mois", $paramMois);
        $requeteMois->execute();
        $mois = $requeteMois->fetch();

        return $mois;
    }

    public static function listerStatsJour($paramAnnee, $paramMois, $paramJour)
    {
        $SQL_JOUR = "SELECT AVG(mesure) as moyenne, MAX(mesure) as max, MIN(mesure) as min
                FROM precipitation
                WHERE date_part('year', moment) = :annee
                AND date_part('month', moment) = :mois
                AND date_part('day', moment) = :jour";
        $requeteJour = BaseDeDonnees::getConnection()->prepare($SQL_JOUR);
        $requeteJour->bindParam(":annee", $paramAnnee);
        $requeteJour->bindParam(":mois", $paramMois);
        $requeteJour->bindParam(":jour", $paramJour);
        $requeteJour->execute();
        $jour = $requeteJour->fetch();

        return $jour;
    }

    public static function listerMois($paramAnnee)
    {
        $SQL_LISTE_MOIS = "SELECT date_part('month', moment) as mois, AVG(mesure) as moyenne, MAX(mesure) as max, MIN(mesure) as min
            FROM precipitation
            WHERE date_part('year', moment) = :annee
            GROUP BY mois
            ORDER BY mois ASC";
        $requeteListeMois = BaseDeDonnees::getConnection()->prepare($SQL_LISTE_MOIS);
        $requeteListeMois->bindParam(":annee", $paramAnnee);
        $requeteListeMois->execute();
        $listeMois = $requeteListeMois->fetchAll();
        return $listeMois;
    }

    public static function listerJours($paramAnnee, $paramMois)
    {
        $SQL_LISTE_JOUR = "SELECT date_part('day', moment) as jour, AVG(mesure) as moyenne, MAX(mesure) as max, MIN(mesure) as min
            FROM precipitation
            WHERE date_part('month', moment) = :mois
            AND date_part('year', moment) = :annee
            GROUP BY jour
            ORDER BY jour ASC";
        $requeteListeJour = BaseDeDonnees::getConnection()->prepare($SQL_LISTE_JOUR);
        $requeteListeJour->bindParam(":mois", $paramMois);
        $requeteListeJour->bindParam(":annee", $paramAnnee);
        $requeteListeJour->execute();
        $listeJour = $requeteListeJour->fetchAll();
        return $listeJour;
    }

    public static function listerHeures($paramAnnee, $paramMois, $paramJour)
    {
        $SQL_LISTE_HEURE = "SELECT date_part('hour', moment) as heure, AVG(mesure) as moyenne, MAX(mesure) as max, MIN(mesure) as min
            FROM precipitation
            WHERE date_part('day', moment) = :jour
            AND date_part('month', moment) = :mois
            AND date_part('year', moment) = :annee
            GROUP BY heure
            ORDER BY heure ASC";
        $requeteListeHeure = BaseDeDonnees::getConnection()->prepare($SQL_LISTE_HEURE);
        $requeteListeHeure->bindParam(":jour", $paramJour);
        $requeteListeHeure->bindParam(":mois", $paramMois);
        $requeteListeHeure->bindParam(":annee", $paramAnnee);
        $requeteListeHeure->execute();
        $listeHeure = $requeteListeHeure->fetchAll();
        return $listeHeure;
    }
}

?>