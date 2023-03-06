package com.islamicfoundation.mbcmlp.data.mapper

import com.islamicfoundation.mbcmlp.data.model.PayloadDataDto
import com.islamicfoundation.mbcmlp.data.model.PayloadDto
import com.islamicfoundation.mbcmlp.domain.model.Payload
import com.islamicfoundation.mbcmlp.domain.model.PayloadData

fun PayloadDto.toPayload() = Payload(
    count = count,
    data = data.toPayloadData()
)

fun PayloadDataDto.toPayloadData() = PayloadData(
     accessToken = accessToken,
     companyImage = companyImage,
     companyName = companyName,
     isAdmin = isAdmin,
     isAffiliator = isAffiliator,
     isCustomer = isCustomer,
     isEmployee = isEmployee,
     isSuperAdmin = isSuperAdmin,
     isUser = isUser,
     phone = phone,
     roleDtos = roleDtos ?: emptyList(),
     userId = userId,
     userName = userName
)