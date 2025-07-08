
package com.cavemind.karlscrypto.ui.onboarding

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.airbnb.lottie.LottieAnimationView
import com.cavemind.karlscrypto.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class OnboardingFragment : Fragment() {
    private lateinit var typewriterText: TextView
    private lateinit var lottieAnimation: LottieAnimationView
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding, container, false)
        typewriterText = view.findViewById(R.id.typewriterText)
        lottieAnimation = view.findViewById(R.id.lottieView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startCinematicIntro()
    }

    private fun startCinematicIntro() {
        lottieAnimation.setAnimation("cinematic_intro.json")
        lottieAnimation.playAnimation()
        lifecycleScope.launch {
            showTypewriter("Analyzing market trends...", R.raw.titan_voice_1)
            delay(2000)
            showTypewriter("Optimizing your portfolio...", R.raw.titan_voice_2)
            delay(2000)
            showTypewriter("Engaging neural risk model...", R.raw.titan_voice_3)
            delay(2000)
            showTypewriter("Launching Titan AI...", R.raw.titan_voice_4)
            delay(2000)
            showTypewriter("Welcome to CoinTrakrAI.", R.raw.titan_voice_5)
            delay(1500)
            (activity as? MainActivity)?.navigateToDashboard()
        }
    }

    private suspend fun showTypewriter(message: String, audioRes: Int) {
        typewriterText.text = ""
        for (char in message) {
            typewriterText.append(char.toString())
            delay(50)
        }
        playVoice(audioRes)
    }

    private fun playVoice(audioRes: Int) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(requireContext(), audioRes)
        mediaPlayer?.start()
    }

    override fun onDestroy() {
        mediaPlayer?.release()
        super.onDestroy()
    }
}
