package model.lidi

import model.enums.TypCloveka
import model.ostatni.Mistenka

data class Clovek(val mistenka: Mistenka
, val typ: TypCloveka
, val id: Long)
