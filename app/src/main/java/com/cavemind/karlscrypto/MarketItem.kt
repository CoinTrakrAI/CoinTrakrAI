@Composable
fun MarketItem(asset: MarketAsset, onSimulateClick: (MarketAsset) -> Unit) {
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Text(asset.name, style = MaterialTheme.typography.bodyMedium)
        Text("\$${"%.2f".format(asset.price)}", style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.height(4.dp))
        Button(onClick = { onSimulateClick(asset) }) {
            Text("Simulate Trade")
        }
    }
}

