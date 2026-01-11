package com.jminnovatech.enjoybazar.ui.customer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jminnovatech.enjoybazar.ui.customer.vm.CustomerViewModel

@Composable
fun AddressScreen(vm: CustomerViewModel) {

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {

        Text("Delivery Address", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(12.dp))

        OutlinedTextField(name, { name = it }, label = { Text("Name") })
        OutlinedTextField(phone, { phone = it }, label = { Text("Phone") })
        OutlinedTextField(address, { address = it }, label = { Text("Address") })

        Spacer(Modifier.height(16.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                vm.saveAddress(name, phone, address)
            }
        ) {
            Text("Save Address")
        }
    }
}

