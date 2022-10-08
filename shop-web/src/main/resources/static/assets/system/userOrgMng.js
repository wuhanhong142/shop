var selectOrg = null;

function deleteOrgData(deptId, deptName, hasChildren) {
    if (hasChildren) {
        Tools.showError("该机构下有子节点不能删除！")
        return
    }
    Tools.showConfirmDialog("删除机构", "确定要删除" + deptName + "吗？", function () {
        Tools.ajaxPost("/system/dept/delete", {
            deptId: deptId
        }, function (res) {
            if (res && res.success == true) {
                Tools.showInfo("删除成功")
                reloadTree();
            } else {
                Tools.showError("删除失败")
            }
        })
    }, true)
}

function uploadUsers() {
    $("#pdfFile").val("");
    $('#pdfFile').aceFileInput({
        btnChooseClass: 'bgc-grey-l2 pt-15 px-2 my-1px mr-1px',
        btnChooseText: '选择文件',
        btnChangeText: '重选',
        placeholderText: '请选择文件',
        placeholderIcon: '<i class="fa fa-file bgc-warning-m1 text-white w-4 py-2 text-center"></i>'
    })
    $(".ace-file-container").css("width", "400px")
    $("#id-modal-upload-user").modal();
}

function uploadData() {
    if (!$("#pdfFile").val()) {
        Tools.showError("请选择文件")
    }
    var form = $("#upload_data_form")[0];
    var formdata = new FormData(form);
    $("#id-btn-upload").prop("disabled", true);
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: '/system/user/uploadUser',
        data: formdata,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (res) {
            if (res && res.success === true) {
                $("#id-modal-upload-user").modal('hide');
                Tools.showInfo("导入成功")
                if (res.data) {
                    window.open("/file/downloadPdf/" + res.data)
                }
                reloadData();
            } else {
                Tools.showError(res.errMessage)
            }
        },
        error: function (res) {
            Tools.showError(res.responseJSON.message)
        }
    });
}

function editUserModal(isNew, parentId, parentName, id, name) {
    $("#id-form-department")[0].reset();
    if (isNew) {
        $("#parentId").val(id);
        $("#parentName").val(name);
        $("#id").val('');
        $("#departmentName").val('');
    } else {
        $("#parentId").val(parentId);
        if(parentId === undefined || parentId === 'undefined') {
            $("#parentName").val("超级父级");
            $("#parentId").val("-1");
        } else {
            $("#parentName").val(parentName);
        }
        $("#id").val(id);
        $("#departmentName").val(name);
    }
    $("#id-modal-department").modal();
}

function submitDept() {
    if ($("#id-form-department").valid()) {
        var formData = $("#id-form-department").serialize();
        Tools.ajaxPost("/system/dept/saveOrUpdate", formData, function (res) {
            if (res && res.success === true) {
                Tools.showInfo("操作成功")
                $("#id-modal-department").modal('hide');
                reloadTree();
            }
        })
    }
}

function initTree() {
    Tools.initTree2("#id-jqtree-categories", "/system/dept/find", function (event) {
        selectOrg = event.node;
        reloadData();
    }, false, null, function (node) {
        var parentId = null, parentName = null;
        if (node.parent) {
            parentId = node.parent.id
            parentName = node.parent.name
        }
        var id = node.id, name = node.name, hasChildren = node.children.length !== 0;
        return "<div class=\"dropdown d-inline-block mb-1 ml-3\" style='height: 24px; width: 24px;'>\n" +
            "                <button class=\"btn btn-outline-default dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\" style=\"padding-left: 0px; padding-top: 0px; padding-bottom: 0px; padding-right: 6px;\"><i class=\"fa fa-angle-down ml-2 text-70\"></i>\n" +
            "                </button>\n" +
            "                <div class=\"dropdown-menu dropdown-caret\" style=\"\">\n" +
            "                    <a class=\"dropdown-item\" href=\"javascript:void(0)\" onclick='editUserModal(true, \"" + parentId + "\", \"" + parentName + "\", \"" + id + "\", \"" + name + "\", " + hasChildren + ")'><i class=\"fa fa-plus mr-1\"></i>新增下级</a>\n" +
            "                    <a class=\"dropdown-item\" href=\"javascript:void(0)\" onclick='editUserModal(false, \"" + parentId + "\", \"" + parentName + "\", \"" + id + "\", \"" + name + "\", " + hasChildren + ")'><i class=\"fa fa-edit mr-1\"></i>编辑机构</a>\n" +
            "                    <a class=\"dropdown-item\" href=\"javascript:void(0)\" onclick='deleteOrgData(\"" + id + "\", \"" + name + "\", " + hasChildren + ")'><i class=\"fa fa-trash mr-1\"></i>删除机构</a>\n" +
            "                </div>\n" +
            "            </div>"
    });
}

function loadData(flag) {
    var selectData = Tools.loadRowData("grid");
    if (selectData == null || selectData.length == 0) {
        Tools.showError("请选择用户")
        return
    }
    if (flag) {
        if (selectData.length > 1) {
            Tools.showError("至多选择一个用户")
            return
        }

        return selectData[0];
    }

    return selectData;
}

function lockOrUnlock(flag, id) {
    var title = flag ? "启用用户" : "停用用户";
    var text = flag ? "确定要启用用户吗？" : "确定要停用用户吗？";
    Tools.showConfirmDialog(title, text, function () {
        Tools.ajaxPost("/system/user/saveOrUpdate", {
            id: id,
            isValid: flag ? 1 : 0
        }, function (res) {
            if (res && res.success === true) {
                var subMsg = flag ? "启用成功" : "停用成功";
                Tools.showInfo(subMsg)
                reloadData();
            }
        })
    }, true)
}

function reloadData() {
    reloadGrid({
        departmentId: selectOrg == null ? null : selectOrg.id,
        userName: $("#userName").val(),
        loginMobile: $("#loginMobile").val(),
        isValid: $("#isValid").val()
    });
}

function reloadGrid(data) {
    $("#grid").jqGrid('setGridParam', {
        'page': 1,
        postData: data
    }).trigger("reloadGrid");
}

function reloadTree() {
    Tools.reloadTree("#id-jqtree-categories")
    selectOrg = null
}

function initRoles() {
    Tools.ajaxPost("/system/role/find", {
        rows: 100000,
        page: 1
    }, function (res) {
        if (res && res.success === true) {
            var datas = res.rows;
            var html = ""
            for (var i = 0; i < datas.length; i++) {
                html += "<div class=\"mb-1\"><label class=\"p-2 ml-n2 bgc-h-orange-l2 radius-1\">" +
                    "<input name='roleIds' type=\"checkbox\" value='" + datas[i].id + "' class=\"bgc-danger brc-h-danger-m1 mr-2\">" + datas[i].roleName + "</label></div>";
            }
            $("#id-modal-role-content").append(html);
        }
    })
}

function chooseRoles() {
    var datas = loadData(false);
    if (!datas) return

    var names = [], ids = [];
    for (var i = 0; i < datas.length; i++) {
        names.push(datas[i].userName)
        ids.push(datas[i].id)

    }
    var html = "给[" + names.join(",") + "]分配角色";
    $("#userIds").val(ids.join(","));
    $("#id-modal-role-title").html(html);
    $("#id-modal-role").modal();
}

function editById(id) {
    var rowData = Tools.getRowData("#grid", id);
    if (rowData) {
        Tools.toSubPage({
            op: 'edit',
            viewName: "system/userEdit",
            data: JSON.parse(JSON.stringify(rowData))
        })
    }
}

function deleteById(id) {
    Tools.showConfirmDialog("删除用户", "确定要删除用户吗?", function () {
        Tools.ajaxPost("system/user/delete", {
            ids: id
        }, function (res) {
            if (res && res.success === true) {
                Tools.showInfo("删除成功")
                reloadData()
            } else {
                Tools.showError("删除失败")
            }
        })
    }, true)
}

function actionFormat(cellValue, options, rowObject) {
    var lockBtn
    if (rowObject.isValid === 1 || rowObject.isValid === "1" || rowObject.isValid === '1') {
        lockBtn = "<div title=\"禁用\" onclick='lockOrUnlock(false, \"" + options.rowId + "\")' " +
        "class=\"action-btn mx-1 px-2px float-none border-0 ui-pg-div ui-inline-del\">" +
            "<span class=\"fas fa-lock text-danger-m1\"></span>" +
            "</div>";
    } else {
        lockBtn = "<div title=\"启用\" onclick='lockOrUnlock(true, \"" + options.rowId + "\")' " +
            "class=\"action-btn mx-1 px-2px float-none border-0 ui-pg-div ui-inline-del\">" +
            "<span class=\"fas fa-lock-open text-danger-m1\"></span>" +
        "</div>";
    }
    var editBtn = "<div title=\"编辑数据\" onclick='editById(\"" + options.rowId + "\")' " +
        "class=\"action-btn mx-1 px-2px float-none border-0 ui-pg-div ui-inline-edit\" " +
        "data-toggle=\"tooltip\" data-placement=\"top\" data-original-title=\"编辑数据\">" +
        "<span class=\"fas fa-pencil-alt text-blue\"></span></div>";
    var deleteBtn = "<div title=\"删除数据\" onclick='deleteById(\"" + options.rowId + "\")' " +
        "class=\"action-btn mx-1 px-2px float-none border-0 ui-pg-div ui-inline-edit\" " +
        "data-toggle=\"tooltip\" data-placement=\"top\" data-original-title=\"删除数据\">" +
        "<span class=\"fas fa-trash text-blue\"></span></div>";
    return editBtn + lockBtn + deleteBtn;
}

function submitRole() {
    if ($("#userIds").val() === null || $("#userIds").val() === "") {
        Tools.showError("未选择用户")
        return
    }
    var formData = $("#id-form-role-choose").serialize();
    Tools.ajaxPost("/system/user/saveRole", formData, function (res) {
        if (res && res.success == true) {
            Tools.showInfo("角色设置成功")
            $("#id-modal-role").modal('hide');
            reloadData()
        } else {
            Tools.showError("角色设置失败")
        }
    })
}

function createTable() {
    Tools.initTable("#grid", "#pager", "用户管理", "/system/user/find",
        ['', '', '', '','', 'ID', '姓名', '登录名', '归属部门', '电话号码', '性别', '职务', '籍贯', '民族', '政治面貌', '学历', '状态', '操作'],
        [
            {name: 'departmentId', index: 'departmentId', hidden: true},
            {name: 'position', index: 'departmentId', hidden: true},
            {name: 'sex', index: 'sex', hidden: true},
            {name: 'political', index: 'political', hidden: true},
            {name: 'isValid', index: 'isValid', hidden: true},
            {name: 'id', index: 'id', hidden: true},
            {
                name: 'name',
                index: 'name',
                align: 'center',
                width: 100,
                search: false,
                sortable: true,
                editable: false
            },
            {
                name: 'userName',
                index: 'userName',
                align: 'center',
                width: 100,
                search: false,
                sortable: true,
                editable: false
            },
            {
                name: 'departmentName',
                index: 'departmentName',
                align: 'center',
                width: 100,
                search: false,
                sortable: true,
                editable: false
            },
            {
                name: 'loginMobile',
                index: 'loginMobile',
                align: 'center',
                width: 100,
                search: false,
                sortable: true,
                editable: false
            },
            {
                name: 'sexText',
                index: 'sexText',
                align: 'center',
                width: 40,
                search: false,
                sortable: true,
                editable: false
            },
            {
                name: 'positionName',
                index: 'positionName',
                align: 'center',
                width: 80,
                search: false,
                sortable: true,
                editable: false
            },
            {
                name: 'hometown',
                index: 'hometown',
                align: 'center',
                width: 60,
                search: false,
                sortable: true,
                editable: false
            },
            {
                name: 'national',
                index: 'national',
                align: 'center',
                width: 40,
                search: false,
                sortable: true,
                editable: false
            },
            {
                name: 'politicalText',
                index: 'politicalText',
                align: 'center',
                width: 60,
                search: false,
                sortable: true,
                editable: false
            },
            {
                name: 'education',
                index: 'education',
                align: 'center',
                width: 60,
                search: false,
                sortable: true,
                editable: false
            },
            {
                name: 'isValidText',
                index: 'isValidText',
                align: 'center',
                width: 40,
                search: false,
                sortable: true,
                editable: false
            },
            {name: 'action', index: 'action', width: 120, align: "center", formatter: actionFormat}
        ],
        true);
}

$(function () {
    initRoles();
    Tools.validateForm("id-form-department");
    $('#id-modal-department').aceAside({
        placement: 'right',
        dismiss: true,
        belowNav: true,
        extrwNav: true,
        extraClass: 'my-2'
    })
    $('#id-modal-role').aceAside({
        placement: 'right',
        dismiss: true,
        belowNav: true,
        extrwNav: true,
        extraClass: 'my-2'
    })
    initTree();
    createTable();
})
