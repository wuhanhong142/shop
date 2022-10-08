$(function (){

        Tools.initTable("#grid",
            "#pager",
            "菜单管理",
            "/system/resource/find",
            ['ID', '菜单名称', '菜单级别', '菜单级别', '父级ID', '父级菜单', '路径', '图标', '创建人', '创建时间', '更新时间', '更新人', '状态', '状态'],
            [
                    { name: 'id', index: 'id', align: 'center', width: 40, search: false, sortable: false, editable: false },
                    { name: 'name', index: 'name', align: 'center', width: 100, search: false, sortable: true, editable: false },
                    { name: 'level', index: 'level', align: 'center', hidden: true, width: 80, search: false, sortable: false, editable: false },
                    { name: 'levelText', index: 'levelText', align: 'center', width: 40, search: false, sortable: false, editable: false },
                    { name: 'parentId', index: 'parentId', align: 'center', hidden: true,width: 80, search: false, sortable: false, editable: false },
                    { name: 'parentName', index: 'parentName', align: 'center', width: 80, search: false, sortable: false, editable: false },
                    { name: 'url', index: 'url', align: 'center', width: 140, search: false, sortable: false, editable: false },
                    { name: 'icon', index: 'icon', align: 'center', width: 80, search: false, sortable: false, editable: false },
                    { name: 'createBy', index: 'createBy', align: 'center', width: 80, search: false, sortable: false, editable: false },
                    { name: 'gmtCreate', index: 'gmtCreate', align: 'center', width: 120, search: false, sortable: false, editable: false,formatter:'date',formatoptions:{srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'} },
                    { name: 'updateBy', index: 'updateBy', align: 'center', width: 80, search: false, sortable: false, editable: false },
                    { name: 'gmtModified', index: 'gmtModified', align: 'center', width: 120, search: false, sortable: false, editable: false,formatter:'date',formatoptions:{srcformat: 'Y-m-d H:i:s', newformat: 'Y-m-d H:i:s'} },
                    { name: 'isValid', index: 'isValid', align: 'center', hidden: true,width: 80, search: false, sortable: false, editable: false },
                    { name: 'isValidText', index: 'isValidText', align: 'center', width: 40, search: false, sortable: false, editable: false }
            ],
            true);

        Tools.click("id-btn-add", function () {
            Tools.toPage("菜单添加", '/system/resourceMng')
        })
})