package model.stanice

import model.enums.Budova
import model.enums.Destinace

data class Stanice(val budova: Budova,
    val destinace: Destinace,
    val nastupiste: Nastupiste
)
