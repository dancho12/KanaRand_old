#include <jni.h>
#include <string.h>
#include <string>
#include "fstream"
#include "time.h"

std::string Res = "";
std::string Res2 = "";
int a=0,b=0;
std::string str[100];
std::string str2[100];

extern "C" JNIEXPORT jstring

JNICALL
Java_com_example_danch_kanarand_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_danch_kanarand_MainActivity_Imput(JNIEnv *env, jobject instance, jstring a_) {
    const char *cstr = env->GetStringUTFChars(a_, NULL);
    str[b] = cstr;
    b++;
    return 0;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_danch_kanarand_MainActivity_Imput2(JNIEnv *env, jobject instance, jstring a_) {
    const char *cstr = env->GetStringUTFChars(a_, NULL);
    str2[b] = cstr;
    a++;
    return 0;
}
extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_danch_kanarand_MainActivity_OutPutRand(JNIEnv *env, jobject instance) {

    int index = 1 + rand() % b;
    Res = str[index-1];
    Res2 = str2[index-1];
    return env->NewStringUTF(Res.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_danch_kanarand_MainActivity_OutPutLat(JNIEnv *env, jobject instance) {

    return env->NewStringUTF(Res2.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_danch_kanarand_MainActivity_Clean(JNIEnv *env, jobject instance) {


    for (int i = 0; i < b; i++) {
        str[i] = "";
        str2[i] = "";
    }

    Res = "";
    b = 0;
    return 0;
}