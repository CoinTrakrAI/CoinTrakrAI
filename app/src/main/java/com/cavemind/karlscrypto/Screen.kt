package com.cavemind.karlscrypto.ui.navigation

Sealed class Screen(val route: String) {
    Object Splash : Screen("splash")
    Object Home : Screen("home")
    Object Dashboard : Screen("dashboard")
    Object Settings : Screen("settings")
    Object Whisper : Screen("whisper")
    Object Profile : Screen("profile")
    Object MirrorTrading : Screen("mirror_trading")
    Object TradingDashboard : Screen("trading_dashboard")
    Object ConfidenceTracking : Screen("confidence_tracking")
    Object VolatilityOptimization : Screen("volatility_optimization")
    Object WhisperSecrets : Screen("whisper_secrets")
    Object ARLiveMap : Screen("ar_live_map")
    Object AutoTunePanel : Screen("auto_tune_panel")
    Object LiveWalletHolo : Screen("live_wallet_holo")
    Object GamifiedRoom : Screen("gamified_room")
    Object SentinelHQ : Screen("sentinel_hq")
    Object HoloTracking : Screen("holo_tracking")
    Object Brain3D : Screen("brain_3d")
}

