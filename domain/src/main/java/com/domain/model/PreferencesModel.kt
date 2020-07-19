package com.domain.model

/**
 * Model for user preferences
 *
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

data class PreferencesModel(
        val preferencesUserModel: PreferencesUserModel = PreferencesUserModel(),
        val preferencesSystemModel: PreferencesSystemModel = PreferencesSystemModel()
)

data class PreferencesUserModel(
        val fingerPrintSelected: Boolean = false,
        val savedSession: Boolean = false,
        val fingerPrintChosen: Boolean = false
)

data class PreferencesSystemModel(
        val tutorialShown: Boolean = false
)