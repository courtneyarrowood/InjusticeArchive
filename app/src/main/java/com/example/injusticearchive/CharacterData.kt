package com.example.injusticearchive


data class CharacterCard(val name: String, val variant: String?, val tier: Tier, val imageResource: Int)

enum class Tier {
    Bronze,
    Silver,
    Gold,
    Metal
}

enum class CharacterFilter {
    All,
    Bronze,
    Silver,
    Gold,
    Metal
}

val allCharacters = listOf(

    // -------------------------------------------- BRONZE CHARACTERS ---------------------------------------- //
    CharacterCard("Catwoman", "Regime", Tier.Bronze, imageResource = R.drawable.catwoman_regime),
    CharacterCard("Cyborg", null, Tier.Bronze, imageResource = R.drawable.cyborg),
    CharacterCard("Deathstroke", "Insurgency", Tier.Bronze, imageResource = R.drawable.deathstroke_insurgency),
    CharacterCard("Green Arrow","Insurgency", Tier.Bronze, imageResource = R.drawable.green_arrow_insurgency),
    CharacterCard("Green Lantern",null, Tier.Bronze, imageResource = R.drawable.green_lantern),
    CharacterCard("Green Lantern","New 52", Tier.Bronze, imageResource = R.drawable.green_lantern_new_52),
    CharacterCard("Harley Quinn", null, Tier.Bronze, imageResource = R.drawable.harley_quinn),
    CharacterCard("Lex Luthor", null, Tier.Bronze, imageResource = R.drawable.lex_luthor),
    CharacterCard("Nightwing", null, Tier.Bronze, imageResource = R.drawable.nightwing),
    CharacterCard("Sinestro", null, Tier.Bronze, imageResource = R.drawable.sinestro),
    CharacterCard("Solomon Grundy", "Regime", Tier.Bronze, imageResource = R.drawable.solomon_grundy_regime),
    CharacterCard("The Flash", null, Tier.Bronze, imageResource = R.drawable.the_flash),
    CharacterCard("The Flash", "New 52", Tier.Bronze, imageResource = R.drawable.the_flash_new_52),

    // -------------------------------------------- SILVER CHARACTERS ---------------------------------------- //
    CharacterCard("Bane", "Knightfall", Tier.Silver, imageResource = R.drawable.bane_knightfall),
    CharacterCard("Bane", "Regime", Tier.Silver, imageResource = R.drawable.bane_regime),
    CharacterCard("Black Adam", null, Tier.Silver, imageResource = R.drawable.black_adam),
    CharacterCard("Catwoman", null, Tier.Silver, imageResource = R.drawable.catwoman),
    CharacterCard("Cyborg", "Regime", Tier.Silver, imageResource = R.drawable.cyborg_regime),
    CharacterCard("Deathstroke",null, Tier.Silver, imageResource = R.drawable.deathstroke),
    CharacterCard("Doomsday", "Regime", Tier.Silver, imageResource = R.drawable.doomsday_regime),
    CharacterCard("Green Arrow", null, Tier.Silver, imageResource = R.drawable.green_arrow),
    CharacterCard("Green Lantern", "Regime", Tier.Silver, imageResource = R.drawable.green_lantern_regime),
    CharacterCard("Harley Quinn", "Insurgency", Tier.Silver, imageResource = R.drawable.harley_quinn_insurgency),
    CharacterCard("Lex Luthor", "Insurgency", Tier.Silver, imageResource = R.drawable.lex_luthor_insurgency),
    CharacterCard("Nightwing", "Regime", Tier.Silver, imageResource = R.drawable.nightwing_regime),
    CharacterCard("Sinestro", "Regime", Tier.Silver, imageResource = R.drawable.sinestro_regime),
    CharacterCard("Solomon Grundy",null, Tier.Silver, imageResource = R.drawable.solomon_grundy),
    CharacterCard("The Flash", "Regime", Tier.Silver, imageResource = R.drawable.the_flash_regime),
    CharacterCard("The Joker", null, Tier.Silver, imageResource = R.drawable.the_joker),
    CharacterCard("Wonder Woman", null, Tier.Silver, imageResource = R.drawable.wonder_woman),

    // -------------------------------------------- GOLD CHARACTERS ---------------------------------------- //
    CharacterCard("Aquaman", null, Tier.Gold, imageResource = R.drawable.aquaman),
    CharacterCard("Aquaman", "Flashpoint", Tier.Gold, imageResource = R.drawable.aquaman_flashpoint),
    CharacterCard("Aquaman", "Injustice 2", Tier.Gold, imageResource = R.drawable.aquaman_injustice_2),
    CharacterCard("Aquaman", "Regime", Tier.Gold, imageResource = R.drawable.aquaman_regime),
    CharacterCard("Ares", null, Tier.Gold, imageResource = R.drawable.ares),
    CharacterCard("Bane", null, Tier.Gold, imageResource = R.drawable.bane),
    CharacterCard("Bane", "Arkham Origins", Tier.Gold, imageResource = R.drawable.bane_arkham_origins),
    CharacterCard("Bane", "Luchador", Tier.Gold, imageResource = R.drawable.bane_luchador),
    CharacterCard("Batgirl", null, Tier.Gold, imageResource = R.drawable.batgirl),
    CharacterCard("Batgirl", "Arkham Knight", Tier.Gold, imageResource = R.drawable.batgirl_arkham_knight),
    CharacterCard("Batgirl", "Cassandra Cain", Tier.Gold, imageResource = R.drawable.batgirl_cassandra_cain),
    CharacterCard("Batman", null, Tier.Gold, imageResource = R.drawable.batman),
    CharacterCard("Batman", "Arkham Knight", Tier.Gold, imageResource = R.drawable.batman_arkham_knight),
    CharacterCard("Batman", "Arkham Origins", Tier.Gold, imageResource = R.drawable.batman_arkham_origins),
    CharacterCard("Batman", "Batman Ninja", Tier.Gold, imageResource = R.drawable.batman_batman_ninja),
    CharacterCard("Batman", "Beyond", Tier.Gold, imageResource = R.drawable.batman_beyond),
    CharacterCard("Batman Beyond", "Animated", Tier.Gold, imageResource = R.drawable.batman_beyond_animated),
    CharacterCard("Batman", "Blackest Night", Tier.Gold, imageResource = R.drawable.batman_blackest_night),
    CharacterCard("Batman", "Dawn of Justice", Tier.Gold, imageResource = R.drawable.batman_dawn_of_justice),
    CharacterCard("Batman", "Flashpoint", Tier.Gold, imageResource = R.drawable.batman_flashpoint),
    CharacterCard("Batman", "Gaslight", Tier.Gold, imageResource = R.drawable.batman_gaslight),
    CharacterCard("Batman", "Insurgency", Tier.Gold, imageResource = R.drawable.batman_insurgency),
    CharacterCard("Batman", "Red Son", Tier.Gold, imageResource = R.drawable.batman_red_son),
    CharacterCard("Black Adam", "Kahndaq", Tier.Gold, imageResource = R.drawable.black_adam_kahndaq),
    CharacterCard("Black Adam", "Regime", Tier.Gold, imageResource = R.drawable.black_adam_regime),
    CharacterCard("Catwoman", "Ame-Comi", Tier.Gold, imageResource = R.drawable.catwoman_ame_comi),
    CharacterCard("Catwoman", "Arkham Knight", Tier.Gold, imageResource = R.drawable.catwoman_arkham_knight),
    CharacterCard("Catwoman", "Batman Returns", Tier.Gold, imageResource = R.drawable.catwoman_batman_returns),
    CharacterCard("Cyborg", "Teen Titans", Tier.Gold, imageResource = R.drawable.cyborg_teen_titans),
    CharacterCard("Darkseid", null, Tier.Gold, imageResource = R.drawable.darkseid),
    CharacterCard("Darkseid", "Apokolips", Tier.Gold, imageResource = R.drawable.darkseid_apokolips),
    CharacterCard("Deadshot", "Arkham Origins", Tier.Gold, imageResource = R.drawable.deadshot_arkham_origins),
    CharacterCard("Deadshot", "Suicide Squad", Tier.Gold, imageResource = R.drawable.deadshot_suicide_squad),
    CharacterCard("Deathstroke", "Arkham Origins", Tier.Gold, imageResource = R.drawable.deathstroke_arkham_origins),
    CharacterCard("Deathstroke", "Flashpoint", Tier.Gold, imageResource = R.drawable.deathstroke_flashpoint),
    CharacterCard("Deathstroke", "Red Son", Tier.Gold, imageResource = R.drawable.deathstroke_red_son),
    CharacterCard("Doomsday", null, Tier.Gold, imageResource = R.drawable.doomsday),
    CharacterCard("Doomsday", "Blackest Night", Tier.Gold, imageResource = R.drawable.doomsday_blackest_night),
    CharacterCard("Doomsday", "Containment", Tier.Gold, imageResource = R.drawable.doomsday_containment),
    CharacterCard("General Zod", "Man of Steel", Tier.Gold, imageResource = R.drawable.general_zod_man_of_steel),
    CharacterCard("Green Arrow", "Arrow", Tier.Gold, imageResource = R.drawable.green_arrow_arrow),
    CharacterCard("Green Arrow", "Rebirth", Tier.Gold, imageResource = R.drawable.green_arrow_rebirth),
    CharacterCard("Green Lantern", "John Stewart", Tier.Gold, imageResource = R.drawable.green_lantern_john_stewart),
    CharacterCard("Green Lantern", "Red Son", Tier.Gold, imageResource = R.drawable.green_lantern_red_son),
    CharacterCard("Hal Jordan","Red Lantern", Tier.Gold, imageResource = R.drawable.hal_jordan_red_lantern),
    CharacterCard("Hal Jordan", "Yellow Lantern", Tier.Gold, imageResource = R.drawable.hal_jordan_yellow_lantern),
    CharacterCard("Harley Quinn", "Animated", Tier.Gold, imageResource = R.drawable.harley_quinn_animated),
    CharacterCard("Harley Quinn", "Arkham", Tier.Gold, imageResource = R.drawable.harley_quinn_arkham),
    CharacterCard("Harley Quinn", "Arkham Knight", Tier.Gold, imageResource = R.drawable.harley_quinn_arkham_knight),
    CharacterCard("Harley Quinn", "Suicide Squad", Tier.Gold, imageResource = R.drawable.harley_quinn_suicide_squad),
    CharacterCard("Hawkgirl", null, Tier.Gold, imageResource = R.drawable.hawkgirl),
    CharacterCard("Hawkgirl", "Blackest Night", Tier.Gold, imageResource = R.drawable.hawkgirl_blackest_night),
    CharacterCard("Hawkgirl", "Earth 2", Tier.Gold, imageResource = R.drawable.hawkgirl_earth_2),
    CharacterCard("Hawkgirl", "Regime", Tier.Gold, imageResource = R.drawable.hawkgirl_regime),
    CharacterCard("Jessica Cruz", "Rebirth", Tier.Gold, imageResource = R.drawable.jessica_cruz_rebirth),
    CharacterCard("Killer Croc", "Arkham", Tier.Gold, imageResource = R.drawable.killer_croc_arkham),
    CharacterCard("Killer Frost", null, Tier.Gold, imageResource = R.drawable.killer_frost),
    CharacterCard("Killer Frost", "Regime", Tier.Gold, imageResource = R.drawable.killer_frost_regime),
    CharacterCard("Lex Luthor", null, Tier.Gold, imageResource = R.drawable.lex_luthor),
    CharacterCard("Lex Luthor", "Krypto", Tier.Gold, imageResource = R.drawable.lex_luthor_krypto),
    CharacterCard("Lobo", null, Tier.Gold, imageResource = R.drawable.lobo),
    CharacterCard("Lobo", "Bounty Hunter", Tier.Gold, imageResource = R.drawable.lobo_bounty_hunter),
    CharacterCard("Lord Joker", "Batman Ninja", Tier.Gold, imageResource = R.drawable.lord_joker_batman_ninja),
    CharacterCard("Martian Manhunter", null, Tier.Gold, imageResource = R.drawable.martian_manhunter),
    CharacterCard("Martian Manhunter", "Blackest Night", Tier.Gold, imageResource = R.drawable.martian_manhunter_blackest_night),
    CharacterCard("Nightwing", "New 52", Tier.Gold, imageResource = R.drawable.nightwing_new_52),
    CharacterCard("Raven", null, Tier.Gold, imageResource = R.drawable.raven),
    CharacterCard("Raven", "Rebirth", Tier.Gold, imageResource = R.drawable.raven_rebirth),
    CharacterCard("Raven", "Regime", Tier.Gold, imageResource = R.drawable.raven_regime,),
    CharacterCard("Raven", "Teen Titans", Tier.Gold, imageResource = R.drawable.raven_teen_titans),
    CharacterCard("Reverse Flash", null, Tier.Gold, imageResource = R.drawable.reverse_flash),
    CharacterCard("Scorpion", "Klassic", Tier.Gold, imageResource = R.drawable.scorpion_klassic),
    CharacterCard("Scorpion", "Mortal Kombat", Tier.Gold, imageResource = R.drawable.scorpion_mortal_kombat),
    CharacterCard("Scorpion", "Mortal Kombat X", Tier.Gold, imageResource = R.drawable.scorpion_mortal_kombat_x),
    CharacterCard("Shazam", null, Tier.Gold, imageResource = R.drawable.shazam),
    CharacterCard("Sinestro", "Antimatter", Tier.Gold, imageResource = R.drawable.sinestro_antimatter),
    CharacterCard("Sinestro", "Green Lantern", Tier.Gold, imageResource = R.drawable.sinestro_green_lantern),
    CharacterCard("Solomon Grundy", "Boss", Tier.Gold, imageResource = R.drawable.solomon_grundy_boss),
    CharacterCard("Solomon Grundy", "Earth 2", Tier.Gold, imageResource = R.drawable.solomon_grundy_earth_2),
    CharacterCard("Solomon Grundy", "Red Son", Tier.Gold, imageResource = R.drawable.solomon_grundy_red_son),
    CharacterCard("Static", null, Tier.Gold, imageResource = R.drawable.static_prime),
    CharacterCard("Superman", null, Tier.Gold, imageResource = R.drawable.superman),
    CharacterCard("Superman", "Blackest Night", Tier.Gold, imageResource = R.drawable.superman_blackest_night),
    CharacterCard("Superman", "Dawn of Justice", Tier.Gold, imageResource = R.drawable.superman_dawn_of_justice),
    CharacterCard("Superman", "Godfall", Tier.Gold, imageResource = R.drawable.superman_godfall),
    CharacterCard("Superman", "Injustice 2", Tier.Gold, imageResource = R.drawable.superman_injustice_2),
    CharacterCard("Superman", "Man of Steel", Tier.Gold, imageResource = R.drawable.superman_man_of_steel),
    CharacterCard("Superman", "New 52", Tier.Gold, imageResource = R.drawable.superman_new_52),
    CharacterCard("Superman", "Prison", Tier.Gold, imageResource = R.drawable.superman_prison),
    CharacterCard("Superman", "Red Son", Tier.Gold, imageResource = R.drawable.superman_red_son),
    CharacterCard("Superman", "Regime", Tier.Gold, imageResource = R.drawable.superman_regime),
    CharacterCard("The Arkham Knight", "Arkham Knight", Tier.Gold, imageResource = R.drawable.the_arkham_knight_arkham_knight),
    CharacterCard("The Flash", "Blackest Night", Tier.Gold, imageResource = R.drawable.the_flash_blackest_night),
    CharacterCard("The Flash", "Earth 2", Tier.Gold, imageResource = R.drawable.the_flash_earth_2),
    CharacterCard("The Flash", "Elseworld", Tier.Gold, imageResource = R.drawable.the_flash_elseworld),
    CharacterCard("The Flash", "Metahuman", Tier.Gold, imageResource = R.drawable.the_flash_metahuman),
    CharacterCard("The Joker", "Arkham Origins", Tier.Gold, imageResource = R.drawable.the_joker_arkham_origins),
    CharacterCard("The Joker", "Suicide Squad", Tier.Gold, imageResource = R.drawable.the_joker_suicide_squad),
    CharacterCard("The Joker", "The Killing Joke", Tier.Gold, imageResource = R.drawable.the_joker_the_killing_joke),
    CharacterCard("The Joker Unhinged", "Suicide Squad", Tier.Gold, imageResource = R.drawable.the_joker_unhinged_suicide_squad),
    CharacterCard("Wally West", "Rebirth", Tier.Gold, imageResource = R.drawable.wally_west_rebirth),
    CharacterCard("Wonder Woman", "600", Tier.Gold, imageResource = R.drawable.wonder_woman_600),
    CharacterCard("Wonder Woman", "Dawn of Justice", Tier.Gold, imageResource = R.drawable.wonder_woman_dawn_of_justice),
    CharacterCard("Wonder Woman", "New 52", Tier.Gold, imageResource = R.drawable.wonder_woman_new_52),
    CharacterCard("Wonder Woman", "Red Son", Tier.Gold, imageResource = R.drawable.wonder_woman_red_son),
    CharacterCard("Wonder Woman", "Regime", Tier.Gold, imageResource = R.drawable.wonder_woman_regime),
    CharacterCard("Zatanna", null, Tier.Gold, imageResource = R.drawable.zatanna),
    CharacterCard("Zod", null, Tier.Gold, imageResource = R.drawable.zod),

    // -------------------------------------------- METAL CHARACTERS ---------------------------------------- //
    CharacterCard("Black Adam", "New 52", Tier.Metal, imageResource = R.drawable.black_adam_new_52),
    CharacterCard("Catwoman", "Batman Ninja", Tier.Metal, imageResource = R.drawable.catwoman_batman_ninja),
    CharacterCard("Nightwing", "New 52", Tier.Metal, imageResource = R.drawable.nightwing_batman_ninja),
    CharacterCard("Shazam", "New 52", Tier.Metal, imageResource = R.drawable.shazam_new_52),
    CharacterCard("The Batman Who Laughs", null, Tier.Metal, imageResource = R.drawable.the_batman_who_laughs),
    CharacterCard("The Merciless", null, Tier.Metal, imageResource = R.drawable.the_merciless),
)

fun findCharacter(name: String, variant: String?): CharacterCard {
    return allCharacters.first {
        it.name == name && it.variant == variant
    }
}


fun CharacterCard.displayName(): String {
    return if (variant == null) {
        name
    } else  {
        "$variant $name"
    }
}