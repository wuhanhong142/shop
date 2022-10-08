function reloadData() {
    $("#grid").jqGrid('setGridParam', {
        'page': 1,
        postData: {
            "roleName": $("#id-search-role-name").val()
        }
    }).trigger("reloadGrid");
}

function editRole() {
    var data = Tools.loadData("#grid", false);
    if (!data) {
        return;
    }
    Tools.toSubPage({viewName: 'system/roleEdit', op: 'edit', data: JSON.parse(JSON.stringify(data))})
}

function deleteRole() {
    var datas = Tools.loadData("#grid", true);
    if (!datas) {
        return;
    }

    Tools.showConfirmDialog("删除角色", "确定要删除选择角色吗?", function () {
        var ids = [];
        for (var i = 0; i < datas.length; i++) {
            ids.push(datas[i].id)
        }
        Tools.ajaxPost("/system/role/delete", {
            roleIds : ids.join(",")
        }, function (res) {
            if (res && res.success == true) {
                Tools.showInfo("删除成功")
                reloadData()
            } else {
                Tools.showError(res.errMessage)
            }
        })
    },true)
}

$(function () {

    Tools.initTable("#grid",
        "#pager",
        "角色管理",
        "/system/role/find",
        ['isValid', 'resourceIds', 'ID', '角色名称', '创建人', '创建时间', '更新时间', '更新人', '状态'],
        [
            {name: 'id', index: 'id', hidden: true},
            {name: 'resourceIds', index: 'resourceIds', hidden: true},
            {name: 'id', index: 'id', stype: 'text', align: 'center', width: 80, search: false, sortable: false, editable: false},
            {
                name: 'roleName',
                index: 'roleName',
                align: 'center',
                width: 100,
                search: false,
                sortable: true,
                editable: false
            },
            {
                name: 'createBy',
                index: 'createBy',
                align: 'center',
                width: 80,
                search: false,
                sortable: false,
                editable: false
            },
            {
                name: 'gmtCreate',
                index: 'gmtCreate',
                align: 'center',
                width: 100,
                search: false,
                sortable: false,
                editable: false,
                formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}
            },
            {
                name: 'gmtModified',
                index: 'gmtModified',
                align: 'center',
                width: 100,
                search: false,
                sortable: false,
                editable: false,
                formatter: 'date', formatoptions: {srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'}
            },
            {
                name: 'updateBy',
                index: 'updateBy',
                align: 'center',
                width: 80,
                search: false,
                sortable: false,
                editable: false
            },
            {
                name: 'isValidText',
                index: 'isValidText',
                align: 'center',
                width: 80,
                search: false,
                sortable: false,
                editable: false
            }
        ],
        true);
})