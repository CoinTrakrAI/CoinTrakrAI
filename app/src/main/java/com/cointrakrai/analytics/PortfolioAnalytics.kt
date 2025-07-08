
package com.cointrakrai.analytics

class PortfolioAnalytics {
    fun calculateROI(assetPrice: Double, purchasePrice: Double): Double {
        return (assetPrice - purchasePrice) / purchasePrice * 100
    }
}
