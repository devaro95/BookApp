package com.domain.exception

import com.domain.INT_ZERO
import java.io.IOException

abstract class BaseException(val code: Int = INT_ZERO, val title: String, val description: String) : IOException(description)