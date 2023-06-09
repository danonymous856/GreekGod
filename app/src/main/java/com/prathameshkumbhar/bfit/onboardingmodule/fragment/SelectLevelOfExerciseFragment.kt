package com.prathameshkumbhar.bfit.onboardingmodule.fragment

import android.content.Context
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.prathameshkumbhar.bfit.coremodule.BaseFragment
import com.prathameshkumbhar.bfit.databinding.FragmentSelectLevelOfExerciseBinding

class SelectLevelOfExerciseFragment : BaseFragment() {
    private var _binding : FragmentSelectLevelOfExerciseBinding? = null
    private val binding get() = _binding!!

    private val  navController by lazy {
        findNavController()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentSelectLevelOfExerciseBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharePrefBeginner : SharedPreferences = context!!.getSharedPreferences("cardBeginner", Context.MODE_PRIVATE)

        val sharePrefIntermediate : SharedPreferences = context!!.getSharedPreferences("cardIntermediate", Context.MODE_PRIVATE)

        val sharePrefAdvance : SharedPreferences = context!!.getSharedPreferences("cardAdvance", Context.MODE_PRIVATE)



        //Selecting the beginner card
        binding.cardBeginner.setOnClickListener {

            binding.cardBeginner.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#14213D")))

            binding.cardBeginner.isChecked = true
            if(binding.cardBeginner.isChecked){
                binding.cardBeginner.strokeWidth = 8
                var beginnerEditor : SharedPreferences.Editor = sharePrefBeginner.edit()
                beginnerEditor.putBoolean("isBeginnerCardCheck", true)
                beginnerEditor.apply()
            }

            binding.cardIntermediate.isChecked = false
            var intermediateEditor : SharedPreferences.Editor = sharePrefIntermediate.edit()
            intermediateEditor.putBoolean("isIntermediateCardCheck", false)
            intermediateEditor.apply()
            binding.cardIntermediate.strokeWidth = 0


            binding.cardAdvanced.isChecked = false
            var advanceEditor : SharedPreferences.Editor = sharePrefAdvance.edit()
            advanceEditor.putBoolean("isAdvanceCardCheck", false)
            advanceEditor.apply()
            binding.cardAdvanced.strokeWidth = 0
        }


        //Selecting the Intermediate card
        binding.cardIntermediate.setOnClickListener {

            binding.cardIntermediate.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#14213D")))

            binding.cardIntermediate.isChecked = true
            if(binding.cardIntermediate.isChecked){
                binding.cardIntermediate.strokeWidth = 8


                var intermediateEditor : SharedPreferences.Editor = sharePrefIntermediate.edit()
                intermediateEditor.putBoolean("isIntermediateCardCheck", true)
                intermediateEditor.apply()
            }

            binding.cardBeginner.isChecked = false
            var beginnerEditor : SharedPreferences.Editor = sharePrefBeginner.edit()
            beginnerEditor.putBoolean("isBeginnerCardCheck", false)
            beginnerEditor.apply()
            binding.cardBeginner.strokeWidth = 0


            binding.cardAdvanced.isChecked = false
            var advanceEditor : SharedPreferences.Editor = sharePrefAdvance.edit()
            advanceEditor.putBoolean("isAdvanceCardCheck", false)
            advanceEditor.apply()
            binding.cardAdvanced.strokeWidth = 0
        }

        //Selecting the Advance card
        binding.cardAdvanced.setOnClickListener {

            binding.cardAdvanced.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#14213D")))

            binding.cardAdvanced.isChecked = true
            if(binding.cardAdvanced.isChecked){
                binding.cardAdvanced.strokeWidth = 8

                var advanceEditor : SharedPreferences.Editor = sharePrefAdvance.edit()
                advanceEditor.putBoolean("isAdvanceCardCheck", true)
                advanceEditor.apply()

            }

            binding.cardIntermediate.isChecked = false
            var intermediateEditor : SharedPreferences.Editor = sharePrefIntermediate.edit()
            intermediateEditor.putBoolean("isIntermediateCardCheck", false)
            intermediateEditor.apply()
            binding.cardIntermediate.strokeWidth = 0



            binding.cardBeginner.isChecked = false
            var beginnerEditor : SharedPreferences.Editor = sharePrefBeginner.edit()
            beginnerEditor.putBoolean("isBeginnerCardCheck", false)
            beginnerEditor.apply()
            binding.cardBeginner.strokeWidth = 0



        }

        binding.nextButtonSelectLevelOfExercise.setOnClickListener {

            if(binding.cardBeginner.isChecked || binding.cardIntermediate.isChecked || binding.cardAdvanced.isChecked){

                navController.navigate(
                    SelectLevelOfExerciseFragmentDirections.actionSelectLevelOfExerciseFragmentToPersonActivityStatusFragment()
                )

            }else{
                infoToast("Kindly select your level !")
            }

        }

    }
}