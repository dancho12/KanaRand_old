#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_example_danch_kanarand_MainActivity_stringFromJNI(JNIEnv *env, jobject instance) {

    // TODO


    return (*env)->NewStringUTF(env, returnValue);
}