package com.uni.demo.create;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateProjectPhaseType {

    public static void main(String[] args) throws Exception{
        Map<String,String> map = new HashMap<>();
        map.put("可研","KY");
        map.put("施工图设计","SGTSJ");
        map.put("工程竣工验收","GCJGYS");
        map.put("方案","FA");
        map.put("初步设计","SGTSJ");
        map.put("其他成果","QTCG");
        map.put("项目建议书","XMJYS");
        map.put("咨询","ZX");
        map.put("规划","GH");
        map.put("可行性研究","KXXYJ");
        map.put("调研","DY");
        map.put("初步方案提交及汇报","CBFATJJHB");
        map.put("专家评审成果提交及汇报","ZJPSCGTJJHB");
        map.put("规委会成果提交及汇报","GWHCGTJJHB");
        map.put("最终成果提交","ZZCGTJ");




        String s = "调研 20%初步方案提交及汇报25%专家评审成果提交及汇报35%规委会成果提交及汇报10%最终成果提交10%\n" +
                "调研 15%初步方案提交及汇报25%专家评审成果提交及汇报50%最终成果提交10%";

        final String replace = s.replace(" ", "");
        final String[] split = replace.split("\n");

        List<List<String>> llist = new ArrayList<>();
        for (String s1 : split) {
            List<String> list = new ArrayList<>();
            llist.add(list);
            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            for (int i = 0; i < s1.length(); i++) {
                char ch = s1.charAt(i);
                if(flag){
                    if(isNumeric(ch+"")){
                        list.add(sb.toString());
                        sb = new StringBuilder();
                        flag = false;
                    }
                }else{
                   if(isContainChinese(ch+"")){
                       list.add(sb.toString());
                       sb = new StringBuilder();
                       flag = true;
                   }
                }
                sb.append(ch);
                if(i == s1.length()-1){
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }

        List<ProjectPhasetype> typeList = new ArrayList<>();
        llist.forEach(list -> {
            List<ProjectPhaseDto> projectPhaseDtoList = new ArrayList<>();
            final ProjectPhasetype projectPhasetype = new ProjectPhasetype();
            projectPhasetype.setList(projectPhaseDtoList);
            typeList.add(projectPhasetype);
            ProjectPhaseDto projectPhaseDto = new ProjectPhaseDto();
            for (int i = 0; i < list.size(); i++) {
                if(i % 2 == 0){
                    projectPhaseDto.setName(list.get(i));
                }else{
                    projectPhaseDto.setPercent(list.get(i));
                    projectPhaseDtoList.add(projectPhaseDto);
                    projectPhaseDto = new ProjectPhaseDto();
                }
            }
        });

        String sql = "insert into prj_phasetype(id,name,type,project_phase) values ";

        int id = 60;
        Set<String> checkName = new HashSet<>();

        for (ProjectPhasetype type : typeList) {

            String name = "";
            for (ProjectPhaseDto dto : type.getList()) {
                name = name + dto.getName() + ">";
            }
            System.out.println(name);
            if(name.endsWith(">"))
                name = name.substring(0,name.length() - 1);

            for (int i = 0; i < type.getList().size(); i++) {
                final ProjectPhaseDto projectPhaseDto = type.getList().get(i);
                projectPhaseDto.setStep(i+1+"");
                if("施工图".equals(projectPhaseDto.getName())){
                    projectPhaseDto.setName("施工图设计");
                }
                String code = map.get(projectPhaseDto.getName());
                if(null == code || "".equals(code)){
                    throw new Exception(projectPhaseDto.getName());
                }

                projectPhaseDto.setCode(code);
            }

            if( checkName.add(name) )
                sql +="("+ (id++) +",'" + name +"','GH','"+ JSON.toJSONString(type.getList()) +"'),";
        }
        System.out.println(sql);

    }

    public static boolean isNumeric(String str){

        Pattern pattern = Pattern.compile("[0-9]*");

        Matcher isNum = pattern.matcher(str);

        if( !isNum.matches() ){
            return false;
        }

        return true;

    }

    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
}
