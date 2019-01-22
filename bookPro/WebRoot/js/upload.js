<script language="javascript" type="text/javascript">
        $(function () {
            var guid = '<%=Request["guid"] %>';
            var type = '<%=Request["type"] %>';
            if (guid == null || guid == "") {
                guid = newGuid();
            }
            if (type != null) {
                type = type + '/';
            }

            $('#file_upload').uploadify({
                'swf': 'uploadify.swf',                        //FLash文件路径
                'buttonText': '浏  览',                        //按钮文本
                'uploader': 'uploadhandler.ashx?guid=' + guid, //处理ASHX页面
                'formData' : { 'folder' : 'picture' },         //传参数
                'queueID': 'fileQueue',                        //队列的ID
                'queueSizeLimit': 10,                           //队列最多可上传文件数量，默认为999
                'auto': false,                                 //选择文件后是否自动上传，默认为true
                'multi': true,                                 //是否为多选，默认为true
                'removeCompleted': true,                       //是否完成后移除序列，默认为true
                'fileSizeLimit': '10MB',                       //单个文件大小，0为无限制，可接受KB,MB,GB等单位的字符串值
                'fileTypeDesc': 'Image Files',                 //文件描述
                'fileTypeExts': '*.gif; *.jpg; *.png; *.bmp',  //上传的文件后缀过滤器
                'onQueueComplete': function (event, data) {    //所有队列完成后事件
                    //ShowUpFiles(guid, type, show_div);
                    alert("上传完毕！");
                },
                'onUploadError': function (event, queueId, fileObj, errorObj) {
                    alert(errorObj.type + "：" + errorObj.info);
                }
            });
        });

        function newGuid() {
            var guid = "";
            for (var i = 1; i <= 32; i++){
              var n = Math.floor(Math.random()*16.0).toString(16);
              guid +=   n;
              if((i==8)||(i==12)||(i==16)||(i==20))
                guid += "-";
            }
            return guid;
        }
    </script>