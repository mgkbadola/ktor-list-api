package me.mgkbadola.utils

val BASE_TABLE = mapOf(Pair("owned", "Games.Owned"), Pair("viewed", "Games.Viewed"))
val CATEGORIES = listOf("main_game", "dlc_addon", "expansion", "bundle", "standalone_expansion", "mod",
    "episode", "season", "remake", "remaster", "expanded_game", "port", "fork", "-") //index from 0
val MODES = listOf("Single player", "Multiplayer", "Co-operative", "Split screen",
    "Massively Multiplayer Online (MMO)", "Battle Royale") //index from 1
val GENRES = mapOf(Pair(4,"Fighting"), Pair(5,"Shooter"), Pair(7,"Music"), Pair(8,"Platform"), Pair(9,"Puzzle"),
    Pair(10,"Racing"), Pair(11,"RealTimeStrategy(RTS)"), Pair(12,"Role-playing(RPG)"), Pair(13,"Simulator"),
    Pair(14,"Sport"), Pair(15,"Strategy"), Pair(16,"Turn-basedstrategy(TBS)"), Pair(24,"Tactical"),
    Pair(26,"Quiz/Trivia"), Pair(25,"Hackandslash/Beat'emup"), Pair(30,"Pinball"), Pair(31,"Adventure"),
    Pair(33,"Arcade"), Pair(34,"VisualNovel"), Pair(32,"Indie"), Pair(35,"Card&BoardGame"), Pair(36,"MOBA"),
    Pair(2,"Point-and-click"))
val THEMES = mapOf(Pair(20, "Thriller"), Pair(18, "Science fiction"), Pair(1, "Action"), Pair(19, "Horror"),
    Pair(21, "Survival"), Pair(17, "Fantasy"), Pair(22, "Historical"), Pair(23, "Stealth"),
    Pair(27, "Comedy"), Pair(28, "Business"), Pair(31, "Drama"), Pair(32, "Non-fiction"),
    Pair(35, "Kids"), Pair(33, "Sandbox"), Pair(38, "Open world"), Pair(39, "Warfare"),
    Pair(41, "4X (explore, expand, exploit, and exterminate)"), Pair(34, "Educational"),
    Pair(43, "Mystery"), Pair(40, "Party"), Pair(44, "Romance"), Pair(42, "Erotic"))
val PLATFORMS = mapOf(Pair(100, "Analogue electronics"), Pair(101, "Ferranti Nimrod Computer"), Pair(102, "EDSAC"),
    Pair(103, "PDP-7"), Pair(104, "HP 2100"), Pair(105, "HP 3000"), Pair(106, "SDS Sigma 7"),
    Pair(107, "Call-A-Computer time-shared mainframe computer system"), Pair(108, "PDP-11"), Pair(109, "CDC Cyber 70"),
    Pair(11, "Xbox"), Pair(110, "PLATO"), Pair(111, "Imlac PDS-1"), Pair(112, "Microcomputer"),
    Pair(113, "OnLive Game System"), Pair(114, "Amiga CD32"), Pair(115, "Apple IIGS"), Pair(116, "Acorn Archimedes"),
    Pair(117, "Philips CD-i"), Pair(118, "FM Towns"), Pair(119, "Neo Geo Pocket"), Pair(12, "Xbox 360"),
    Pair(120, "Neo Geo Pocket Color"), Pair(121, "Sharp X68000"), Pair(122, "Nuon"), Pair(123, "WonderSwan Color"),
    Pair(124, "SwanCrystal"), Pair(125, "PC-8801"), Pair(126, "TRS-80"), Pair(127, "Fairchild Channel F"),
    Pair(128, "PC Engine SuperGrafx"), Pair(129, "Texas Instruments TI-99"), Pair(13, "PC DOS"),
    Pair(130, "Nintendo Switch"), Pair(131, "Nintendo PlayStation"), Pair(132, "Amazon Fire TV"),
    Pair(133, "Philips Videopac G7000"), Pair(134, "Acorn Electron"), Pair(135, "Hyper Neo Geo 64"),
    Pair(136, "Neo Geo CD"), Pair(137, "New Nintendo 3DS"), Pair(138, "VC 4000"),
    Pair(139, "1292 Advanced Programmable Video System"), Pair(14, "Mac"), Pair(140, "AY-3-8500"),
    Pair(141, "AY-3-8610"), Pair(142, "PC-50X Family"), Pair(143, "AY-3-8760"), Pair(144, "AY-3-8710"),
    Pair(145, "AY-3-8603"), Pair(146, "AY-3-8605"), Pair(147, "AY-3-8606"), Pair(148, "AY-3-8607"),
    Pair(149, "PC-98"), Pair(15, "Commodore C64/128"), Pair(150, "Turbografx-16/PC Engine CD"),
    Pair(151, "TRS-80 Color Computer"), Pair(152, "FM-7"), Pair(153, "Dragon 32/64"), Pair(154, "Amstrad PCW"),
    Pair(155, "Tatung Einstein"), Pair(156, "Thomson MO5"), Pair(157, "NEC PC-6000 Series"),
    Pair(158, "Commodore CDTV"), Pair(159, "Nintendo DSi"), Pair(16, "Amiga"), Pair(161, "Windows Mixed Reality"),
    Pair(162, "Oculus VR"), Pair(163, "SteamVR"), Pair(164, "Daydream"), Pair(165, "PlayStation VR"),
    Pair(166, "PokÃ©mon mini"), Pair(167, "PlayStation 5"), Pair(169, "Xbox Series X|S"), Pair(170, "Google Stadia"),
    Pair(18, "Nintendo Entertainment System (NES)"), Pair(19, "Super Nintendo Entertainment System (SNES)"),
    Pair(20, "Nintendo DS"), Pair(203, "DUPLICATE Stadia"), Pair(21, "Nintendo GameCube"), Pair(22, "Game Boy Color"),
    Pair(23, "Dreamcast"), Pair(236, "Exidy Sorcerer"), Pair(237, "Sol-20"), Pair(238, "DVD Player"),
    Pair(239, "Blu-ray Player"), Pair(24, "Game Boy Advance"), Pair(240, "Zeebo"), Pair(25, "Amstrad CPC"),
    Pair(26, "ZX Spectrum"), Pair(27, "MSX"), Pair(274, "PC-FX"), Pair(29, "Sega Mega Drive/Genesis"), Pair(3, "Linux"),
    Pair(30, "Sega 32X"), Pair(306, "Satellaview"), Pair(307, "Game &amp; Watch"), Pair(308, "Playdia"),
    Pair(309, "Evercade"), Pair(32, "Sega Saturn"), Pair(33, "Game Boy"), Pair(339, "Sega Pico"), Pair(34, "Android"),
    Pair(35, "Sega Game Gear"), Pair(37, "Nintendo 3DS"), Pair(372, "OOParts"), Pair(373, "Sinclair ZX81"),
    Pair(374, "Sharp MZ-2200"), Pair(375, "Epoch Cassette Vision"), Pair(376, "Epoch Super Cassette Vision"),
    Pair(377, "Plug &amp; Play"), Pair(378, "Gamate"), Pair(379, "Game.com"), Pair(38, "PlayStation Portable"),
    Pair(380, "Casio Loopy"), Pair(381, "Playdate"), Pair(382, "Intellivision Amico"), Pair(384, "Oculus Quest"),
    Pair(385, "Oculus Rift"), Pair(386, "Oculus Quest 2"), Pair(387, "Oculus Go"), Pair(388, "Gear VR"),
    Pair(389, "AirConsole"), Pair(39, "iOS"), Pair(390, "PlayStation VR2"), Pair(4, "Nintendo 64"), Pair(41, "Wii U"),
    Pair(42, "N-Gage"), Pair(44, "Tapwave Zodiac"), Pair(46, "PlayStation Vita"), Pair(47, "Virtual Console (Nintendo)"),
    Pair(48, "PlayStation 4"), Pair(49, "Xbox One"), Pair(5, "Wii"), Pair(50, "3DO Interactive Multiplayer"),
    Pair(51, "Family Computer Disk System"), Pair(52, "Arcade"), Pair(53, "MSX2"), Pair(55, "Legacy Mobile Device"),
    Pair(57, "WonderSwan"), Pair(58, "Super Famicom"), Pair(59, "Atari 2600"), Pair(6, "PC (Microsoft Windows)"),
    Pair(60, "Atari 7800"), Pair(61, "Atari Lynx"), Pair(62, "Atari Jaguar"), Pair(63, "Atari ST/STE"),
    Pair(64, "Sega Master System"), Pair(65, "Atari 8-bit"), Pair(66, "Atari 5200"), Pair(67, "Intellivision"),
    Pair(68, "ColecoVision"), Pair(69, "BBC Microcomputer System"), Pair(7, "PlayStation"), Pair(70, "Vectrex"),
    Pair(71, "Commodore VIC-20"), Pair(72, "Ouya"), Pair(73, "BlackBerry OS"), Pair(74, "Windows Phone"),
    Pair(75, "Apple II"), Pair(77, "Sharp X1"), Pair(78, "Sega CD"), Pair(79, "Neo Geo MVS"), Pair(8, "PlayStation 2"),
    Pair(80, "Neo Geo AES"), Pair(82, "Web browser"), Pair(84, "SG-1000"), Pair(85, "Donner Model 30"),
    Pair(86, "TurboGrafx-16/PC Engine"), Pair(87, "Virtual Boy"), Pair(88, "Odyssey"), Pair(89, "Microvision"),
    Pair(9, "PlayStation 3"), Pair(90, "Commodore PET"), Pair(91, "Bally Astrocade"), Pair(93, "Commodore 16"),
    Pair(94, "Commodore Plus/4"), Pair(95, "PDP-1"), Pair(96, "PDP-10"), Pair(97, "PDP-8"), Pair(98, "DEC GT40"),
    Pair(99, "Family Computer"))

val CLIENT_ID = System.getenv("CLIENT_ID")!!
val CLIENT_SECRET = System.getenv("CLIENT_SECRET")!!
val TOKEN_URL = "https://id.twitch.tv/oauth2/token?" +
                "client_id=${CLIENT_ID}&client_secret=${CLIENT_SECRET}&grant_type=client_credentials"
val GAME_URL = System.getenv("GAME_URL")!!
val BASE_BODY = System.getenv("BASE_BODY")!!

val POST_AUTH = System.getenv("POST_AUTH")!!
var TOKEN = "dummy token"
var EXPIRES_ON = 1L