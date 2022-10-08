var Tools = Tools || {};


Tools.click = function (id, click) {
    $("#" + id).on("click", function () {
        click();
    });
};
Tools.ajaxPost = function (url, data, success) {
    $.ajax({
        url: url,
        type: "post",
        dataType: 'JSON',
        data: data,
        success: (res) => {
            success(res)
        },
        error: (res) => {
            Tools.showError(res.responseJSON.errMsg)
        }
    });
};
Tools.ajaxPostJson = function (url, data, success) {
    $.ajax({
        url: url,
        type: "post",
        contentType: "application/json",
        dataType: 'JSON',
        data: JSON.stringify(data),
        success: (res) => {
            success(res)
        },
        error: (res) => {
            Tools.showError(res.responseJSON.errMsg)
        }
    });
};
Tools.ajaxGet = function (url, data, success) {
    $.ajax({
        url: url,
        type: "get",
        dataType: 'JSON',
        data: data,
        success: (res) => {
            success(res)
        },
        error: (res) => {
            Tools.showError(res.responseJSON.errMsg)
        }
    });
};
Tools.showError = function (msg) {
    $.aceToaster.add({
        placement: 'tc',
        body: "<div class='p-3 m-2 d-flex'>\
                         <span class='align-self-center text-center mr-3 py-2 px-1 border-1 bgc-danger radius-round'>\
                            <i class='fa fa-times text-180 w-4 text-white mx-2px'></i>\
                         </span>\
                         <div>\
                            <h4 class='text-dark-tp3'>错误信息</h4>\
                            <span class='text-dark-tp3 text-110'>" + msg + "</span>\
                         </div>\
                        </div>\
                        ",
        width: 480,
        delay: 3000,
        close: false,
        className: 'shadow border-none radius-0 border-l-4 brc-danger',
        bodyClass: 'border-0 p-0',
        headerClass: 'd-none'
    })
};
Tools.showInfo = function (msg) {
    $.aceToaster.add({
        placement: 'tc',
        title: '提示信息!',
        body: msg,
        icon: '<i class="text-blue mr-2 text-130">\
                        <i class="fas fa-exclamation-circle mt-25 fa-2x text-blue"></i>\
                       </i>',
        iconClass: 'mt-3',
        delay: 5000,
        closeClass: 'btn btn-light-danger border-0 btn-bgc-tp btn-xs px-2 py-0 text-150 position-tr mt-n25',

        className: 'bgc-white-tp1 border-none border-t-4 brc-primary-tp1 rounded-sm pl-3 pr-1',
        headerClass: 'bg-transparent border-0 text-120 text-blue-d3 font-bolder mt-3',
        bodyClass: 'pt-0 pb-3 text-105'
    })
};
Tools.toPage = function (title, url, element) {
    $("#id-div-sidebar").find('li').removeClass('active');
    $(element).parents('li').addClass('active');
    $("#id-div-main-content").load("toPage?random=" + Math.random() + "&viewName=" + url);
};
Tools.toSubPage = function (data) {
    $("#id-div-main-content").load("toSubPage?random=" + Math.random(), JSON.parse(JSON.stringify(data)));
};
Tools.initTable = function (grid_selector, pager_selector, title, url, colNames, colModel, multiselect, shrinkToFit) {
    var parent_column = $("#gbox_grid-table").closest('.col-12')
    $(window).on('resize.jqGrid', function () {
        $(grid_selector).jqGrid('setGridWidth', parent_column.width())
    })
    $('.sidebar').on('expand.ace.sidebar', function () {
    }).on('collapsed.ace.sidebar expanded.ace.sidebar', function () {
        $(grid_selector).jqGrid('setGridWidth', parent_column.width())
    })
    $.extend($.jgrid.jqModal, {
        zIndex: 1100
    })
    $.jgrid.guiStyles.bootstrap4ace = {
        baseGuiStyle: "bootstrap4",
        gBox: "",
        gView: "",
        hDiv: "border-y-1 brc-grey-l2 mt-n1px bgc-secondary-l3",
        hTable: "text-uppercase text-80 text-dark-tp3",
        colHeaders: "pl-2 pr-1 text-center",
        gridTitle: "bgc-primary-d1 text-white text-125 p-25",
        grid: "table table-hover table-bordered text-dark-m1 text-95 border-0 brc-grey-l2",
        titleButton: "btn btn-primary border-0 mr-2 px-2 w-auto radius-1",
        gridRow: "bgc-h-success-l3",
        actionsButton: "action-btn mx-1 px-2px float-none border-0",
        states: {
            select: "bgc-success-l2 bgc-h-success-l1",
            th: "bgc-yellow-l1 text-blue-d2",
            hoverTh: "bgc-yellow-l1 text-dark-m3",
            error: "alert bgc-danger-l3"
        },
        overlay: "modal-backdrop",
        dialog: {
            header: "modal-header bgc-default-l4 text-blue-m1 py-2 px-3",
            window: "modal mw-100",
            document: "modal-dialog mw-none",
            content: "modal-content p-0",
            body: "modal-body px-2 py-25 text-130",
            footer: "modal-footer",
            closeButton: "mr-1 mt-n25 px-2 py-1 w-auto h-auto border-1 brc-h-warning-m1 bgc-h-warning-l1 text-danger radius-round",
            fmButton: "btn btn-sm btn-default",
            viewLabel: "control-label py-2",
            dataField: "form-control my-2 ml-1 w-auto",
            viewCellLabel: "text-right w-4 pr-2",
            viewData: "text-left text-secondary-d2 d-block border-1 brc-grey-l2 p-2 radius-1 my-2 ml-1"
        },
        searchDialog: {
            elem: "form-control w-95",
            operator: "form-control w-95",
            label: "form-control w-95",
            addRuleButton: "btn btn-xs btn-outline-primary radius-round btn-bold px-2 mx-1 text-110",
            addGroupButton: "btn btn-xs btn-primary mx-1 text-110",
            deleteRuleButton: "h-4 px-2 pt-0 text-150 mr-1 btn btn-xs btn-outline-danger border-0",
            deleteGroupButton: "h-4 px-2 pt-0 text-150 mr-1 btn btn-xs btn-outline-danger border-0",
        },
        navButton: "action-btn border-0 text-110 mx-1",
        pager: {
            pager: "py-3 px-1 px-md-2 bgc-primary-l4 border-t-1 brc-default-l2 mt-n1px",
            pagerInput: "form-control form-control-sm text-center d-inline-block",
            pagerSelect: "form-control w-6 px-1",
            pagerButton: "p-0 m-0 border-0 radius-round text-110",
        },
        subgrid: {
            button: "", //don't remove
            row: "bgc-secondary-l4 p-0",
        },
        loading: "alert bgc-primary-l3 brc-primary-m2 text-dark-tp3 text-120 px-4 py-3",
    }
    var _pageBtn = "btn w-4 h-4 px-0 mx-2px btn-outline-lightgrey btn-h-outline-primary btn-a-outline-primary radius-round bgc-white"
    $.jgrid.icons.icons4ace = {
        baseIconSet: "fontAwesome5",
        common: "fas",
        actions: {
            edit: "fa-pencil-alt text-blue",
            del: "fa-trash-alt text-danger-m1",
            save: "fa-check text-success",
            cancel: "fa-times text-orange-d2"
        },
        pager: {
            first: "fa-angle-double-left " + _pageBtn,
            prev: "fa-angle-left " + _pageBtn,
            next: "fa-angle-right " + _pageBtn,
            last: "fa-angle-double-right " + _pageBtn
        },
        gridMinimize: {
            visible: "fa-chevron-up",
            hidden: "fa-chevron-down"
        },
        sort: {
            common: "far",
            asc: "fa-caret-up",
            desc: "fa-caret-down"
        },
        form: {
            close: "fa-times my-2px",
            prev: "fa-chevron-left",
            next: "fa-chevron-right",
            save: "fa-check",
            undo: "fa-times",
            del: "fa-trash-alt",
            cancel: "fa-times",
            resizableLtr: "fa-rss fa-rotate-270 text-orange-d1 text-105"
        }
    }
    $(grid_selector).jqGrid({
        iconSet: "icons4ace",
        guiStyle: "bootstrap4ace",
        multiselectWidth: 36,
        url: url,
        mtype: 'post',
        datatype: "json",
        height: '100%', //optional
        sortable: true,
        colNames: colNames,
        colModel: colModel,
        altRows: true,
        altclass: 'bgc-secondary-l5',
        viewrecords: true,
        rowNum: 10,
        rowList: [10, 20, 30],
        pager: pager_selector,
        multiselect: multiselect,
        loadComplete: function () {
            setTimeout(function () {
                $(window).triggerHandler('resize.jqGrid');
            }, 0);
            //$(".action-btn").tooltip()
        },
        caption: title,
        autowidth: true,
        shrinkToFit: shrinkToFit ? shrinkToFit : true,
        forceFit: true,
        onPaging: function (pgButton) {
            setTimeout(function () {
                $(grid_selector).jqGrid('setGridWidth', parent_column.width());
            }, 0);
        }
    })

    $(grid_selector).jqGrid('setFrozenColumns');
};
Tools.initFrozenTable = function (parent,grid_selector, pager_selector, title, url, colNames, colModel, multiselect) {
    var parent_width = $(parent).width()
    $(window).on('resize.jqGrid', function () {
        $(grid_selector).jqGrid('setGridWidth',  $(parent).width())
    })
    $('.sidebar').on('expand.ace.sidebar', function () {
    }).on('collapsed.ace.sidebar expanded.ace.sidebar', function () {
        $(grid_selector).jqGrid('setGridWidth', $(parent).width())
    })
    $.extend($.jgrid.jqModal, {
        zIndex: 1100
    })
    $.jgrid.guiStyles.bootstrap4ace = {
        baseGuiStyle: "bootstrap4",
        gBox: "",
        gView: "",
        hDiv: "border-y-1 brc-grey-l2 mt-n1px bgc-secondary-l3",
        hTable: "text-uppercase text-80 text-dark-tp3",
        colHeaders: "pl-2 pr-1 text-center",
        gridTitle: "bgc-primary-d1 text-white text-125 p-25",
        grid: "table table-hover table-bordered text-dark-m1 text-95 border-0 brc-grey-l2",
        titleButton: "btn btn-primary border-0 mr-2 px-2 w-auto radius-1",
        gridRow: "bgc-h-success-l3",
        actionsButton: "action-btn mx-1 px-2px float-none border-0",
        states: {
            select: "bgc-success-l2 bgc-h-success-l1",
            th: "bgc-yellow-l1 text-blue-d2",
            hoverTh: "bgc-yellow-l1 text-dark-m3",
            error: "alert bgc-danger-l3"
        },
        overlay: "modal-backdrop",
        dialog: {
            header: "modal-header bgc-default-l4 text-blue-m1 py-2 px-3",
            window: "modal mw-100",
            document: "modal-dialog mw-none",
            content: "modal-content p-0",
            body: "modal-body px-2 py-25 text-130",
            footer: "modal-footer",
            closeButton: "mr-1 mt-n25 px-2 py-1 w-auto h-auto border-1 brc-h-warning-m1 bgc-h-warning-l1 text-danger radius-round",
            fmButton: "btn btn-sm btn-default",
            viewLabel: "control-label py-2",
            dataField: "form-control my-2 ml-1 w-auto",
            viewCellLabel: "text-right w-4 pr-2",
            viewData: "text-left text-secondary-d2 d-block border-1 brc-grey-l2 p-2 radius-1 my-2 ml-1"
        },
        searchDialog: {
            elem: "form-control w-95",
            operator: "form-control w-95",
            label: "form-control w-95",
            addRuleButton: "btn btn-xs btn-outline-primary radius-round btn-bold px-2 mx-1 text-110",
            addGroupButton: "btn btn-xs btn-primary mx-1 text-110",
            deleteRuleButton: "h-4 px-2 pt-0 text-150 mr-1 btn btn-xs btn-outline-danger border-0",
            deleteGroupButton: "h-4 px-2 pt-0 text-150 mr-1 btn btn-xs btn-outline-danger border-0",
        },
        navButton: "action-btn border-0 text-110 mx-1",
        pager: {
            pager: "py-3 px-1 px-md-2 bgc-primary-l4 border-t-1 brc-default-l2 mt-n1px",
            pagerInput: "form-control form-control-sm text-center d-inline-block",
            pagerSelect: "form-control w-6 px-1",
            pagerButton: "p-0 m-0 border-0 radius-round text-110",
        },
        subgrid: {
            button: "", //don't remove
            row: "bgc-secondary-l4 p-0",
        },
        loading: "alert bgc-primary-l3 brc-primary-m2 text-dark-tp3 text-120 px-4 py-3",
    }
    var _pageBtn = "btn w-4 h-4 px-0 mx-2px btn-outline-lightgrey btn-h-outline-primary btn-a-outline-primary radius-round bgc-white"
    $.jgrid.icons.icons4ace = {
        baseIconSet: "fontAwesome5",
        common: "fas",
        actions: {
            edit: "fa-pencil-alt text-blue",
            del: "fa-trash-alt text-danger-m1",
            save: "fa-check text-success",
            cancel: "fa-times text-orange-d2"
        },
        pager: {
            first: "fa-angle-double-left " + _pageBtn,
            prev: "fa-angle-left " + _pageBtn,
            next: "fa-angle-right " + _pageBtn,
            last: "fa-angle-double-right " + _pageBtn
        },
        gridMinimize: {
            visible: "fa-chevron-up",
            hidden: "fa-chevron-down"
        },
        sort: {
            common: "far",
            asc: "fa-caret-up",
            desc: "fa-caret-down"
        },
        form: {
            close: "fa-times my-2px",
            prev: "fa-chevron-left",
            next: "fa-chevron-right",
            save: "fa-check",
            undo: "fa-times",
            del: "fa-trash-alt",
            cancel: "fa-times",
            resizableLtr: "fa-rss fa-rotate-270 text-orange-d1 text-105"
        }
    }
    $(grid_selector).jqGrid({
        iconSet: "icons4ace",
        guiStyle: "bootstrap4ace",
        multiselectWidth: 36,
        url: url,
        mtype: 'post',
        datatype: "json",
        height: '100%', //optional
        width: parent_width,
        sortable: true,
        colNames: colNames,
        colModel: colModel,
        altRows: true,
        altclass: 'bgc-secondary-l5',
        viewrecords: true,
        rowNum: 10,
        rowList: [10, 20, 30],
        pager: pager_selector,
        multiselect: multiselect,
        loadComplete: function () {
            setTimeout(function () {
                $(window).triggerHandler('resize.jqGrid');
            }, 0);
            //$(".action-btn").tooltip()
        },
        caption: title,
        shrinkToFit: false,
        onPaging: function (pgButton) {
            setTimeout(function () {
                $(grid_selector).jqGrid('setGridWidth', parent.width());
            }, 0);
        }
    })
    $(grid_selector).jqGrid('setFrozenColumns');
};
Tools.getRowData = function (grid_selector, id) {
    return $(grid_selector).jqGrid('getRowData', id);
}
Tools.createTableHeader = function (grid_selector, groupHeader) {
    $(grid_selector).jqGrid('setGroupHeaders', {
        useColSpanStyle: true,
        groupHeaders:groupHeader
    })
}
Tools.loadRowData = function (a) {
    var ids = $('#' + a).jqGrid('getGridParam', 'selarrrow');
    var h = ids.length;
    var k = [];
    for (var g = 0; g < h; g++) {
        var l = $("#" + a).jqGrid("getRowData", ids[g]);
        k.push(l);
    }
    return k;
};
Tools.loadData = function (grid_selector, multipleFlag) {
    var selectData = Tools.loadRowData("grid");
    if (selectData == null || selectData.length === 0) {
        Tools.showError("请选择数据")
        return
    }
    if (!multipleFlag) {
        if (selectData.length > 1) {
            Tools.showError("至多选择一条数据")
            return
        }
        return selectData[0];
    }
    return selectData;
};
Tools.showConfirmDialog = function (title, text, confirm, showCancelButton) {
    var swalWithBootstrapButtons = Swal.mixin({
        buttonsStyling: false
    })
    swalWithBootstrapButtons.fire({
        title: title,
        text: text,
        type: 'warning',
        showCancelButton: showCancelButton,
        scrollbarPadding: false,
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        reverseButtons: true,
        customClass: {
            'confirmButton': 'btn btn-green mx-2 px-3',
            'cancelButton': 'btn btn-red mx-2 px-3'
        }
    }).then(function (result) {
        if (result.value) {
            confirm();
        } else if (result.dismiss === Swal.DismissReason.cancel) {
        }
    })
};
Tools.formReadOnly = function (b) {
    var a = $("#" + b);
    a.find(':input:not("button")').attr("readonly", "readonly").attr("disabled", "disabled").removeAttr("onclick");
    a.find("select.chosen-select").trigger("chosen:updated");
    a.find("button").attr("disabled", "disabled");
};
Tools.initFormData = function (e, g) {
    var a = $("#" + g);
    var c = a.find("input");
    c.each(function () {
        if (e[this.name]) {
            this.value = e[this.name];
        }
    });
    var f = a.find("select");
    f.each(function () {
        if (e[this.name] || e[this.name] == "0") {
            if (typeof (e[this.name]) == "string") {
                $(this).val(e[this.name].split(","));
            } else {
                $(this).val(e[this.name]);
            }
        }
    });
    var d = a.find("textarea");
    d.each(function () {
        if (e[this.name]) {
            this.value = e[this.name];
        }
    });
};
Tools.validateFormWithoutRule = function (form_selector) {
    var $invalidClass = 'brc-danger-tp2'
    var $validClass = 'brc-info-tp2'
    $('#' + form_selector).validate({
        errorElement: 'span',
        errorClass: 'form-text form-error text-danger-m2',
        focusInvalid: false,
        ignore: "",
        highlight: function (element) {
            var $element = $(element);
            $element.closest('.form-group').find('.form-text').remove()
            if ($element.is('input[type=checkbox]') || $element.is('input[type=radio]')) return
            else if ($element.is('.select2')) {
                var container = $element.siblings('[class*="select2-container"]')
                container.find('.select2-selection').addClass($invalidClass)
            } else if ($element.is('.chosen')) {
                var container = $element.siblings('[class*="chosen-container"]');
                container.find('.chosen-choices, .chosen-single').addClass($invalidClass)
            } else {
                $element.addClass($invalidClass + ' d-inline-block').removeClass($validClass)
            }
        },
        success: function (error, element) {
            var parent = error.parent()
            var $element = $(element)
            $element.removeClass($invalidClass)
                .closest('.form-group').find('.form-text').remove()
            if ($element.is('input[type=checkbox]') || $element.is('input[type=radio]')) return
            else if ($element.is('.select2')) {
                var container = $element.siblings('[class*="select2-container"]')
                container.find('.select2-selection').removeClass($invalidClass)
            } else if ($element.is('.chosen')) {
                var container = $element.siblings('[class*="chosen-container"]')
                container.find('.chosen-choices, .chosen-single').removeClass($invalidClass)
            } else {
                $element.addClass($validClass + ' d-inline-block')
            }
            parent.append('<span class="form-text d-inline-block ml-sm-2"><i class=" fa fa-check text-success-m1 text-120"></i></span>')
        },

        errorPlacement: function (error, element) {
            error.prepend('<i class="form-text fa fa-exclamation-circle text-danger-m1 text-100 mr-1 ml-2"></i>')
            if (element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
                element.closest('div[class*="col-"]').append(error)
            } else if (element.is('.select2')) {
                var container = element.siblings('[class*="select2-container"]')
                error.insertAfter(container)
                container.find('.select2-selection').addClass($invalidClass)
            } else if (element.is('.chosen')) {
                var container = element.siblings('[class*="chosen-container"]')
                error.insertAfter(container)
                container.find('.chosen-choices, .chosen-single').addClass($invalidClass)
            } else {
                error.addClass('d-inline-block').insertAfter(element)
            }
        }
    })
}
Tools.validateForm = function (form_selector, rules, messages) {
    var $invalidClass = 'brc-danger-tp2'
    var $validClass = 'brc-info-tp2'
    $('#' + form_selector).validate({
        errorElement: 'span',
        errorClass: 'form-text form-error text-danger-m2',
        focusInvalid: false,
        ignore: "",
        rules: rules,
        messages: messages,
        highlight: function (element) {
            var $element = $(element);
            $element.closest('.form-group').find('.form-text').remove()
            if ($element.is('input[type=checkbox]') || $element.is('input[type=radio]')) return
            else if ($element.is('.select2')) {
                var container = $element.siblings('[class*="select2-container"]')
                container.find('.select2-selection').addClass($invalidClass)
            } else if ($element.is('.chosen')) {
                var container = $element.siblings('[class*="chosen-container"]');
                container.find('.chosen-choices, .chosen-single').addClass($invalidClass)
            } else {
                $element.addClass($invalidClass + ' d-inline-block').removeClass($validClass)
            }
        },
        success: function (error, element) {
            var parent = error.parent()
            var $element = $(element)
            $element.removeClass($invalidClass)
                .closest('.form-group').find('.form-text').remove()
            if ($element.is('input[type=checkbox]') || $element.is('input[type=radio]')) return
            else if ($element.is('.select2')) {
                var container = $element.siblings('[class*="select2-container"]')
                container.find('.select2-selection').removeClass($invalidClass)
            } else if ($element.is('.chosen')) {
                var container = $element.siblings('[class*="chosen-container"]')
                container.find('.chosen-choices, .chosen-single').removeClass($invalidClass)
            } else {
                $element.addClass($validClass + ' d-inline-block')
            }
            parent.append('<span class="form-text d-inline-block ml-sm-2"><i class=" fa fa-check text-success-m1 text-120"></i></span>')
        },

        errorPlacement: function (error, element) {
            error.prepend('<i class="form-text fa fa-exclamation-circle text-danger-m1 text-100 mr-1 ml-2"></i>')
            if (element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
                element.closest('div[class*="col-"]').append(error)
            } else if (element.is('.select2')) {
                var container = element.siblings('[class*="select2-container"]')
                error.insertAfter(container)
                container.find('.select2-selection').addClass($invalidClass)
            } else if (element.is('.chosen')) {
                var container = element.siblings('[class*="chosen-container"]')
                error.insertAfter(container)
                container.find('.chosen-choices, .chosen-single').addClass($invalidClass)
            } else {
                error.addClass('d-inline-block').insertAfter(element)
            }
        }
    })
};
Tools.initTree = function (jqtree, categoryData, click, multipleSelect, initData) {
    var selectedIcon =
        '<span class="selected-icon d-inline-block text-center border-1 bgc-orange-d1 px-1px mx-1 text-70 pb-1px radius-2px">\
          <i class="w-2 fa fa-check text-white"></i>\
      </span>'

    var deselectedIcon =
        '<span class="deselected-icon d-inline-block text-center border-1 bgc-white brc-secondary-m3 px-1px mx-1 text-70 pb-1px radius-2px">\
          <i class="w-2 fa fa-square-o text-orange-l3"></i>\
      </span>'
    var categoryTree = $(jqtree)
    categoryTree.tree({
        data: categoryData,
        autoOpen: true,
        useContextMenu: false,
        dragAndDrop: false,
        closedIcon: $('<i class="bgc-white w-2 far fa-plus-square text-grey-l1 text-110"></i>'),
        openedIcon: $('<i class="bgc-white w-2 far fa-minus-square text-default-d2 text-110"></i>'),
        onCreateLi: function (node, $li, is_selected) {
            var title = $li.find('.jqtree-title')
            if (node.children.length == 0) {
                title.addClass('text-grey-d2 text-95')
                if (is_selected) {
                    $(selectedIcon).insertBefore(title)
                } else {
                    $(deselectedIcon).insertBefore(title)
                }
            } else {
                title.addClass('text-secondary-d3 font-italic')
            }

            $li.find('.jqtree-element').addClass('bgc-h-warning-l3 radius-1')
        }
    })
    categoryTree.on('tree.click', function (e) {
        if (multipleSelect) {
            e.preventDefault()
            var selectedNode = e.node
            if (selectedNode.id === undefined || selectedNode.children.length > 0) {
                return
            }
            if (categoryTree.tree('isNodeSelected', selectedNode)) {
                categoryTree.tree('removeFromSelection', selectedNode)
                var icon = $(selectedNode.element).find('.selected-icon')
                $(deselectedIcon).insertAfter(icon)
                icon.remove()
            } else {
                categoryTree.tree('addToSelection', selectedNode)
                var icon = $(selectedNode.element).find('.deselected-icon')
                $(selectedIcon).insertAfter(icon)
                icon.remove()
            }
        }
        click(e)
    })

    if (initData) {
        for (var i = 0; i < initData.length; i++) {
            const node = categoryTree.tree('getNodeById', initData[i]);
            if (node && (node.children == null || node.children.length === 0)) {
                categoryTree.tree('addToSelection', node)
                var icon = $(node.element).find('.deselected-icon')
                $(selectedIcon).insertAfter(icon)
                icon.remove()
            }
        }
    }

    return categoryTree
};
Tools.initTree2 = function (jqtree, url, click, multipleSelect, initData, treeEdit) {
    var selectedIcon =
        '<span class="selected-icon d-inline-block text-center border-1 bgc-orange-d1 px-1px mx-1 text-70 pb-1px radius-2px">\
          <i class="w-2 fa fa-check text-white"></i>\
      </span>'

    var deselectedIcon =
        '<span class="deselected-icon d-inline-block text-center border-1 bgc-white brc-secondary-m3 px-1px mx-1 text-70 pb-1px radius-2px">\
          <i class="w-2 fa fa-times text-orange-l3"></i>\
      </span>'
    var categoryTree = $(jqtree)
    categoryTree.tree({
        dataUrl: url,
        dataFilter: function(data) {
            return data.data;
        },
        autoOpen: true,
        useContextMenu: false,
        dragAndDrop: false,
        closedIcon: $('<i class="bgc-white w-2 far fa-plus-square text-grey-l1 text-110"></i>'),
        openedIcon: $('<i class="bgc-white w-2 far fa-minus-square text-default-d2 text-110"></i>'),
        onCreateLi: function (node, $li, is_selected) {
            var title = $li.find('.jqtree-title')
            if (node.children.length == 0) {
                title.addClass('text-grey-d2 text-95')
                if (is_selected) {
                    $(selectedIcon).insertBefore(title)
                } else {
                    $(deselectedIcon).insertBefore(title)
                }
            } else {
                title.addClass('text-secondary-d3 font-italic')
            }

            if (treeEdit)
                $(treeEdit(node)).insertAfter(title);
            $li.find('.jqtree-element').addClass('bgc-h-warning-l3 radius-1')
        }
    })
    categoryTree.on('tree.click', function (e) {
        if (multipleSelect) {
            e.preventDefault()
            var selectedNode = e.node
            if (selectedNode.id === undefined || selectedNode.children.length > 0) {
                return
            }
            if (categoryTree.tree('isNodeSelected', selectedNode)) {
                categoryTree.tree('removeFromSelection', selectedNode)
                var icon = $(selectedNode.element).find('.selected-icon')
                $(deselectedIcon).insertAfter(icon)
                icon.remove()
            } else {
                categoryTree.tree('addToSelection', selectedNode)
                var icon = $(selectedNode.element).find('.deselected-icon')
                $(selectedIcon).insertAfter(icon)
                icon.remove()
            }
        }
        click(e)
    })

    if (initData) {
        for (var i = 0; i < initData.length; i++) {
            const node = categoryTree.tree('getNodeById', initData[i]);
            if (node && (node.children == null || node.children.length === 0)) {
                categoryTree.tree('addToSelection', node)
                var icon = $(node.element).find('.deselected-icon')
                $(selectedIcon).insertAfter(icon)
                icon.remove()
            }
        }
    }

    return categoryTree
};
Tools.reloadTree = function (jqtree) {
    $(jqtree).tree('reload');
};
Tools.initDatepicker = function (datepicker, format) {
    $('#' + datepicker).datetimepicker({
        icons: {
            time: 'far fa-clock text-green-d1 text-120',
            date: 'far fa-calendar text-blue-d1 text-120',
            up: 'fa fa-chevron-up text-secondary',
            down: 'fa fa-chevron-down text-secondary',
            previous: 'fa fa-chevron-left text-secondary',
            next: 'fa fa-chevron-right text-secondary',
            today: 'far fa-calendar-check text-purple-d1 text-120',
            clear: 'fa fa-trash-alt text-orange-d2 text-120',
            close: 'fa fa-times text-danger text-120'
        },
        sideBySide: true,
        toolbarPlacement: "top",
        allowInputToggle: true,
        showClose: false,
        showClear: false,
        showTodayButton: false,
        format: format
    })
    $('#' + datepicker).on('dp.show', function () {
        $(this).find('.collapse.in').addClass('show')
        $(this).find('.table-condensed').addClass('table table-borderless')
        $(this).find('[data-action][title]').tooltip() // enable tooltip
    })
}
