package test;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * 加载bean方式 实现ImportSelector
 * author：xuyy
 * date：2021/3/8  10:54 上午
 */
@RestController
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"test.AutoConfigOne"};
    }
}
