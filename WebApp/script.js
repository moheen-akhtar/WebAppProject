var selectedRow = null

function onFormSubmit() {
    if(Validate()) {
    var formData = readFormData();
    if (selectedRow==null)
    insertNewRecord(formData);
    else UpdateRecord(formData);
    resetForm();
    }
}

function readFormData() {
    var formData = {};
    formData["Student_ID"] = document.getElementById("Student_ID").value;
    formData["FirstName"] = document.getElementById("FirstName").value; 
    formData["LastName"] = document.getElementById("LastName").value;
    formData["Email"] = document.getElementById("Email").value; 
    return formData;
}

function insertNewRecord(data) {
    var table = document.getElementById("StudentList").getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(table.length);
    cell1 = newRow.insertCell(0);
    cell1.innerhtml = data.Student_ID;
    cell2 = newRow.insertCell(1);
    cell2.innerhtml = data.FirstName;
    cell3 = newRow.insertCell(2);
    cell3.innerhtml = data.LastName;
    cell4 = newRow.insertCell(3);
    cell4.innerhtml = data.Email; 
    cell4 = newRow.insertCell(4);
    cell4.innerhtml = `<a onClick="onEdit(this)">Edit</a><a onClick="onDelete(this)>Delete</a>`;
}

function resetForm() {
    document.getElementById("Student_ID").value = "";
    document.getElementById("FirstName").value = "";
    document.getElementById("LastName").value = "";
    document.getElementById("Email").value = "";
    selectedRow = null;
}

function onEdit(td) {
    selectedRow = td.parentElement.parentElement
    document.getElementById("Student_ID").value = selectedRow.cells[0].innerhtml;
    document.getElementById("FirstName").value = selectedRow.cells[1].innerhtml;
    document.getElementById("LastName").value = selectedRow.cells[2].innerhtml;
    document.getElementById("Email").value = selectedRow.cells[3].innerhtml
}

function UpdateRecord(formData) {
    selectedRow.cells[0].innerhtml = formData.Student_ID;
    selectedRow.cells[1].innerhtml = formData.FullName;
    selectedRow.cells[2].innerhtml = formData.LastName;
    selectedRow.cells[3].innerhtml = formData.Email; 
}

function onDelete(td) {
    if (confirm(`Are you sure you want to delete this record?`)) {
    row = td.parentElement.parentElement;
    document.getElementById("StudentList").deleteRow(row.rowIndex);
    resetForm();
    
    }
}
function Validate() {
    isValid = true;
    if (document.getElementById("Student_ID").value == "") {
    isValid = false;
    document.getElementById("StudentIDValidationError").classList.remove("hide"); 
    }

    else {
        isValid = true;
        if (!document.getElementById("StudentIDValidationError").classList.contains("hide"))
        document.getElementById("StudentIDValidationError").classList.add("hide");
    }
    return isValid;
}

