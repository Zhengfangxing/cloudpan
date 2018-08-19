/**
 * Website: http://git.oschina.net/hbbcs/bootStrap-addTabs
 * 
 * Created by joe on 2015-12-19.
 */

/**
 * 
 * @param {type} options {
 * content string||html 鐩存帴鎸囧畾鍐呭
 * close bool 鏄惁鍙互鍏抽棴
 * monitor 鐩戣鐨勫尯鍩�
 * }
 * 
 * @returns
 */
$.fn.addtabs = function (options) {
    obj = $(this);
    options = $.extend({
        content: '', //鐩存帴鎸囧畾鎵�湁椤甸潰TABS鍐呭
        close: true, //鏄惁鍙互鍏抽棴
        monitor: 'body', //鐩戣鐨勫尯鍩�
        iframeUse: true, //浣跨敤iframe杩樻槸ajax
        iframeHeight: $(document).height() - 105, //鍥哄畾TAB涓璉FRAME楂樺害,鏍规嵁闇�鑷繁淇敼
        callback: function () { //鍏抽棴鍚庡洖璋冨嚱鏁�
        }
    }, options || {});

    $(options.monitor).on('click', '[addtabs]', function () {
        _add({
            id: $(this).attr('addtabs'),
            title: $(this).attr('title') ? $(this).attr('title') : $(this).html(),
            content: options.content ? options.content : $(this).attr('content'),
            url: $(this).attr('url'),
        });
    });

    obj.on('click', '.close-tab', function () {
        id = $(this).prev("a").attr("aria-controls");
        _close(id);
    });

    $(window).resize(function () {
        obj.find('iframe').attr('height', options.iframeHeight);
       // _drop();
    });

    _add = function (opts) {
        id = 'tab_' + opts.id;
        obj.find('.active').removeClass('active');
        //濡傛灉TAB涓嶅瓨鍦紝鍒涘缓涓�釜鏂扮殑TAB
        if (!$("#" + id)[0]) {
            //鍒涘缓鏂癟AB鐨則itle
            title = $('<li role="presentation" id="tab_' + id + '"><a href="#' + id + '" aria-controls="' + id + '" role="tab" data-toggle="tab">' + opts.title + '</a></li>');
            //鏄惁鍏佽鍏抽棴
            if (options.close) {
                title.append(' <i class="close-tab glyphicon glyphicon-remove"></i>');
            }
            //鍒涘缓鏂癟AB鐨勫唴瀹�
            content = $('<div role="tabpanel" class="tab-pane" id="' + id + '"></div>');
            //鏄惁鎸囧畾TAB鍐呭
            if (opts.content) {
                content.append(opts.content);
            } else if (options.iframeUse) {//娌℃湁鍐呭锛屼娇鐢↖FRAME鎵撳紑閾炬帴
                content.append('<iframe src="' + opts.url + '" width="100%" height="' + options.iframeHeight +
                        '" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling-x="no" scrolling-y="auto" allowtransparency="yes"></iframe></div>');
            } else {
                $.get(opts.url,function(data){
                    content.append(data); 
                });
            }
            //鍔犲叆TABS
            obj.find('.nav-tabs').append(title);
            obj.find(".tab-content").append(content);
        }

        //婵�椿TAB
        $("#tab_" + id).addClass('active');
        $("#" + id).addClass("active");
        //_drop();
    };
    
    _close = function (id) {
        //濡傛灉鍏抽棴鐨勬槸褰撳墠婵�椿鐨凾AB锛屾縺娲讳粬鐨勫墠涓�釜TAB
        if (obj.find("li.active").attr('id') == "tab_" + id) {
            $("#tab_" + id).prev().addClass('active');
            $("#" + id).prev().addClass('active');
        }
        //鍏抽棴TAB
        $("#tab_" + id).remove();
        $("#" + id).remove();
       // _drop();
        options.callback();
    };
/*
    _drop = function () {
        element=obj.find('.nav-tabs');
        //鍒涘缓涓嬫媺鏍囩
        var dropdown = $('<li class="dropdown pull-right hide tabdrop"><a class="dropdown-toggle" data-toggle="dropdown" href="#">' +
                '<i class="glyphicon glyphicon-align-justify"></i>' +
                ' <b class="caret"></b></a><ul class="dropdown-menu"></ul></li>');
        //妫�祴鏄惁宸插鍔�
        if (!$('.tabdrop').html()) {
            dropdown.prependTo(element);
        } else {
            dropdown = element.find('.tabdrop');
        }
        //妫�祴鏄惁鏈変笅鎷夋牱寮�
        if (element.parent().is('.tabs-below')) {
            dropdown.addClass('dropup');
        }
        var collection = 0;

        //妫�煡瓒呰繃涓�鐨勬爣绛鹃〉
        element.append(dropdown.find('li'))
                .find('>li')
                .not('.tabdrop')                
                .each(function () {
                    if (this.offsetTop > 0) {
                        dropdown.find('ul').append($(this));
                        collection++;
                    }
                });

        //濡傛灉鏈夎秴鍑虹殑锛屾樉绀轰笅鎷夋爣绛�
        濡傛灉鏈夎秴鍑虹殑锛屾樉绀轰笅鎷夋爣绛?
        if (collection > 0) {
            dropdown.removeClass('hide');
            if (dropdown.find('.active').length == 1) {
                dropdown.addClass('active');
            } else {
                dropdown.removeClass('active');
            }
        } else {
            dropdown.addClass('hide');
        }
    }; 
    
    */
};