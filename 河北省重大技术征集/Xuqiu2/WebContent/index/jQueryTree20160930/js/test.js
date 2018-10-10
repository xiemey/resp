$(function () {

    var json =
        [{
            "name": "科技活动类型",
            "code":"ZKCH",
            "icon": "icon-th",
            "child": [
                {
                    "name": "基础研究",
                    "icon": "icon-minus-sign",
                    "code":"GZZKCH",
                    "parentCode": "ZKCH",
                    "child": [
                        {
                            "name": "学科",
                            "code":"GZZKCHTQFH",
                            "icon": "",
                            "parentCode": "GZZKCH",
                            "child": [
                                      {
                                    	  "name": "语文",
                                          "code":"yuwen",
                                          "icon": "",
                                          "parentCode": "GZZKCHTQFH",
                                          "child": []
                                      },
                                      {
                                    	  "name": "数学",
                                          "code":"shuxue",
                                          "icon": "",
                                          "parentCode": "GZZKCHTQFH",
                                          "child": []
                                      },
                                      {
                                    	  "name": "英语",
                                          "code":"english",
                                          "icon": "",
                                          "parentCode": "GZZKCHTQFH",
                                          "child": []
                                      },
                                      {
                                    	  "name": "化学",
                                          "code":"huaxue",
                                          "icon": "",
                                          "parentCode": "GZZKCHTQFH",
                                          "child": []
                                      },
                                      {
                                    	  "name": "美术",
                                          "code":"meishu",
                                          "icon": "",
                                          "parentCode": "GZZKCHTQFH",
                                          "child": []
                                      }
                                      ]
                        }
                    ]
                },
                {
                    "name": "应用研究",
                    "icon": "",
                    "code":"yinyong",
                    "parentCode": "ZKCH",
                    "child": [
                        {
                            "name": "需求所属领域",
                            "code":"xuqiulingyu",
                            "icon": "",
                            "parentCode": "yinyong",
                            "child": [
                                      {
                                    	  "name": "电子信息",
                                          "code":"dianzi",
                                          "icon": "",
                                          "parentCode": "xuqiulingyu",
                                          "child": []
                                      },
                                      {
                                    	  "name": "光机电-体化",
                                          "code":"guangji",
                                          "icon": "",
                                          "parentCode": "xuqiulingyu",
                                          "child": []
                                      },
                                      {
                                    	  "name": "生物技术领域与制药",
                                          "code":"shengwu",
                                          "icon": "",
                                          "parentCode": "xuqiulingyu",
                                          "child": []
                                      },
                                      {
                                    	  "name": "新材料及应用",
                                          "code":"xincailiao",
                                          "icon": "",
                                          "parentCode": "xuqiulingyu",
                                          "child": []
                                      },
                                      {
                                    	  "name": "现代农业",
                                          "code":"nongye",
                                          "icon": "",
                                          "parentCode": "xuqiulingyu",
                                          "child": []
                                      },
                                      {
                                    	  "name": "新能源与高效节能",
                                          "code":"xinnengyuan",
                                          "icon": "",
                                          "parentCode": "xuqiulingyu",
                                          "child": []
                                      },
                                      {
                                    	  "name": "资源与环境",
                                          "code":"ziyuan",
                                          "icon": "",
                                          "parentCode": "xuqiulingyu",
                                          "child": []
                                      },
                                      {
                                    	  "name": "高技术职务业",
                                          "code":"gaojishu",
                                          "icon": "",
                                          "parentCode": "xuqiulingyu",
                                          "child": []
                                      },
                                      {
                                    	  "name": "海洋",
                                          "code":"haiyang",
                                          "icon": "",
                                          "parentCode": "xuqiulingyu",
                                          "child": []
                                      },
                                      {
                                    	  "name": "社会公共事业",
                                          "code":"shehui",
                                          "icon": "",
                                          "parentCode": "xuqiulingyu",
                                          "child": []
                                      },
                                      {
                                    	  "name": "医疗卫生",
                                          "code":"yiliaoweisheng",
                                          "icon": "",
                                          "parentCode": "xuqiulingyu",
                                          "child": []
                                      },
                                      {
                                    	  "name": "其他",
                                          "code":"qita",
                                          "icon": "",
                                          "parentCode": "xuqiulingyu",
                                          "child": []
                                      }
                                      ]
                        },
                        {
                            "name": "需求技术应用行业",
                            "code":"xuqiuhangye",
                            "icon": "",
                            "parentCode": "yinyong",
                            "child": [
										{
											"name": "自动化",
										    "code":"zidong",
										    "icon": "",
										    "parentCode": "xuqiuhangye",
										    "child": []
										},
										{
											"name": "IT",
										    "code":"it",
										    "icon": "",
										    "parentCode": "xuqiuhangye",
										    "child": []
										},
										{
											"name": "医疗",
										    "code":"yiliaohangye",
										    "icon": "",
										    "parentCode": "xuqiuhangye",
										    "child": []
										}
                                      ]
                        },
                    ]
                }
                
                
                
            ]
        }];


    function tree(data) {
        for (var i = 0; i < data.length; i++) {
            var data2 = data[i];
            if (data[i].icon == "icon-th") {
                $("#rootUL").append("<li data-name='" + data[i].code + "'><span><i class='" + data[i].icon + "'></i> " + data[i].name + "</span></li>");
            } else {
                var children = $("li[data-name='" + data[i].parentCode + "']").children("ul");
                if (children.length == 0) {
                    $("li[data-name='" + data[i].parentCode + "']").append("<ul></ul>")
                }
                $("li[data-name='" + data[i].parentCode + "'] > ul").append(
                    "<li data-name='" + data[i].code + "'>" +
                    "<span>" +
                    "<i class='" + data[i].icon + "'></i> " +
                    data[i].name +
                    "</span>" +
                    "</li>")
            }
            for (var j = 0; j < data[i].child.length; j++) 
            {
                var child = data[i].child[j];
                var children = $("li[data-name='" + child.parentCode + "']").children("ul");
                if (children.length == 0) 
                {
                    $("li[data-name='" + child.parentCode + "']").append("<ul></ul>")
                }
                $("li[data-name='" + child.parentCode + "'] > ul").append(
                    "<li data-name='" + child.code + "'>" +
                    "<span>" +
                    "<i class='" + child.icon + "'></i> " +"<a herf='gg.jsp'>"+
                    child.name +"</a>"+
                    "</span>" +
                    "</li>")
                var child2 = data[i].child[j].child;
                tree(child2)
            }
            tree(data[i]);
        }

    }

    tree(json)


});