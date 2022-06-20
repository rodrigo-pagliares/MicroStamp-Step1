var systemSafetyConstraintSelected;
var systemSafetyConstraintToBeDeleted;
var nullHazardFound;
var hazard_modal;
/*
$(window).ready(function () {
    var project_id = $("#project_id").val();
    $.ajax({
        "type": 'get',
        "url": '/systemsafetyconstraints/findByProjectId/' + project_id,
        "dataType": "json",
        "success": function (data) {
            $.each(data, function (idx, obj) {
                console.log(obj);
                $("#systemSafetyConstraintsTable").append("<tr data-tt-id=\"" + obj.id + "\" data-tt-parent-id=\"" + obj.father + "\"><td>" + obj.name + "</td><td>" + obj.id + "</td><td><button style='cursor: pointer; border-radius: 5px;' data-toggle='modal' data-target='#editSystemSafetyConstraintModal' onclick = loadEditSystemSafetyConstraint(this.id) type='button' id=\"" + obj.id + "\"><span class='fa fa-pencil' aria-hidden='true'></span></button><button style='cursor: pointer; border-radius: 5px;' data-toggle='modal' data-target='#confirmSystemSafetyConstraintDeleteModal' type='button' id=\"" + obj.id + "\" onclick = loadSystemSafetyConstraintToBeDeleted(this.id)><span class='fa fa-trash'></span></button></td></tr>");
            });
            $("#systemSafetyConstraintsTable").treetable({
                expandable: true,
                initialState: "expanded",
                clickableNodeNames: true,
                indent: 30
            });
        }
    });
});
*/

async function addSystemSafetyConstraint() {
    var systemSafetyConstraint = {
        name: $("#system-safety-constraint-name").val(),
        projectId: $("#project_id").val(),
        hazardId: $("#system-safety-constraint-hazard").val(),
    }

    $('#target').html('sending..');

    if($("#system-safety-constraint-name").val() == ""){
        $("#addSystemSafetyConstraintModal").modal("hide");
        actual_modal = 0;
        $("#namelessRestrictionModal").modal("show");
    }else{
        await checkSelectedHazard($("#system-safety-constraint-hazard").val())
        if(nullHazardFound){
            $.ajax({
                url: '/systemsafetyconstraints',
                type: 'post',
                dataType: 'text',
                contentType: 'application/json',
                success: function (data) {
                    location.reload();
                },
                data: JSON.stringify(systemSafetyConstraint)
            });
        }else{
            $("#addSystemSafetyConstraintModal").modal("hide");
            hazard_modal = 0;
            $("#hazardRestrictionModal").modal("show");
        }
    }
}

function loadEditSystemSafetyConstraint(id){
    systemSafetyConstraintSelected = id;
    $.ajax({
        url: '/systemsafetyconstraints/'+ id,
        type: 'get',
        success: function (data) {
            $("#system-safety-constraint-edit-name").val(data.name);
        },
    });
}

async function editSystemSafetyConstraint() {
    var systemSafetyConstraint = {
        name: $("#system-safety-constraint-edit-name").val(),
        hazardId: $("#system-safety-constraint-edit-hazard").val(),
    }

    $('#target').html('sending..');

    if($("#system-safety-constraint-edit-name").val() == ""){
        $("#editSystemSafetyConstraintModal").modal("hide");
        actual_modal = 1;
        $("#namelessRestrictionModal").modal("show");
    }else{
        await checkSelectedHazard($("#system-safety-constraint-edit-hazard").val())
        if(nullHazardFound){
            $.ajax({
                url: '/systemsafetyconstraints/' + systemSafetyConstraintSelected,
                type: 'put',
                dataType: 'text',
                contentType: 'application/json',
                success: function (data) {
                    location.reload();
                },
                data: JSON.stringify(systemSafetyConstraint)
            });
        }else{
            $("#editSystemSafetyConstraintModal").modal("hide");
            hazard_modal = 1;
            $("#hazardRestrictionModal").modal("show");
        }
    }
}

function loadSystemSafetyConstraintToBeDeleted(id){
    systemSafetyConstraintToBeDeleted = id;
    $.ajax({
        url: '/systemsafetyconstraints/'+ id,
        type: 'get',
        success: function (data) {
             $("#system_safety_constraint_delete_name").text(data.name);
        },
    });
}

function deleteSystemSafetyConstraint(){
    $.ajax({
        url: '/systemsafetyconstraints/'+ systemSafetyConstraintToBeDeleted,
        type: 'delete',
        success: function (data) {
            location.reload();
        },
    });
}

async function checkSelectedHazard(hazardId){
    var project_id = $("#project_id").val();
    nullHazardFound = false;
    await $.ajax({
       url: '/hazards/findUnselectedHazardsByProject/'+ project_id,
       type: 'get',
       success: function (data) {
           $.each(data, function (idx, obj) {
               if(obj.id == hazardId){
                   nullHazardFound = true;
               }
           });
       },
    });
}

function returnHazardRestriction(){
    $("#hazardRestrictionModal").modal("hide");
    if(hazard_modal == 0)
        $("#addSystemSafetyConstraintModal").modal("show");
    else
        $("#editSystemSafetyConstraintModal").modal("show");
}
