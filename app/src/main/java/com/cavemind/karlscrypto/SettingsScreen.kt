@Composable
fun SettingsScreen(viewModel: SettingsViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val notificationsEnabled by viewModel.notificationsEnabled.collectAsState()
    val darkModeEnabled by viewModel.darkModeEnabled.collectAsState()

    Surface(
        Modifier = Modifier.fillMaxSize(),
        Color = Color.Black
    ) {
        Column(
            Modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                Text = "Settings",
                Color = Color.Yellow,
                fontSize = 28.sp
            )
            Spacer(modifier = Modifier.height(24.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Enable Notifications", color = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Switch(
                    Checked = notificationsEnabled,
                    onCheckedChange = { viewModel.toggleNotifications(it) }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Enable Dark Mode", color = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Switch(
                    Checked = darkModeEnabled,
                    onCheckedChange = { viewModel.toggleDarkMode(it) }
                )
            }
        }
    }
}

