var upload = {

    exportData : function (fileChannel) {
        var formData = $("#query-form").serialize();
        window.open('upload/exportFile?fileChannel=' + fileChannel + "&" + formData)
    },
    importData : function () {
        $("#uploadDialog").modal("show");
    },
    downloadFile : function (fileChannel) {
        window.open('system/common/download?fileName=' + fileChannel)
    },
    submitUpload : function (url, success) {
        var form = $("#uploadForm")[0];
        var data = new FormData(form);
        $("#id-btn-upload").prop("disabled", true);
        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: url,
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {
                $("#id-btn-upload").removeAttr("disabled");
                $("#uploadDialog").modal("hide");
                Tools.showInfo("文件上传成功")
                success(data);
            },
            error: function (e) {
                $("#id-btn-upload").removeAttr("disabled");
                Tools.showError("文件上传失败")
            }
        });

    },
    initXlsx: function () {
        $('#uploadFile').aceFileInput({
            style: 'drop',
            droppable: false,
            container: 'border-1 border-dashed brc-grey-l1 brc-h-info-m2 shadow-sm',
            placeholderClass: 'text-125 text-600 text-grey-l1 my-2',
            placeholderText: '拖动文件或者点击选择',
            placeholderIcon: '<i class="fa fa-cloud-upload-alt fa-3x text-info-m2 my-2"></i>',
            allowExt: 'xls|xlsx'
        })
    }
}