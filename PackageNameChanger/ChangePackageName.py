import os, sys

__author__ = 'Udinic'


###########################################
##         Base folder config
basePath = "C:\<project path>"
###########################################

# for a single file name - replace all the old package references with the new package references
def refactorFile(fileName):
    old_lines = open(fileName, "r").readlines()
    temp_buffer = ""

    for old_line in old_lines:
        new_line = old_line
        if old_line.find("com." + srcPackage + ".") <> -1:
            new_line = old_line.replace("com." + srcPackage + ".", "com." + destPackage + ".")
        elif old_line.find("com_" + srcPackage + "_") <> -1:
            new_line = old_line.replace("com_" + srcPackage + "_", "com_" + destPackage + "_")
        elif old_line.find("\"com." + srcPackage + "\"") <> -1:
            new_line = old_line.replace("\"com." + srcPackage + "\"",
                                        "\"com." + destPackage + "\"")
        elif old_line.find(appNameStringBefore) <> -1:
            new_line = old_line.replace(appNameStringBefore, appNameString)
        elif old_line.find("\"http://schemas.android.com/apk/res/com." + srcPackage + "\"") <> -1:
            new_line = old_line.replace("\"http://schemas.android.com/apk/res/com." + srcPackage + "\"",
                                        "\"http://schemas.android.com/apk/res/com." + destPackage + "\"")
        if old_line != new_line:
            print "OLD:", old_line, "\nNEW:", new_line, "\n"

        temp_buffer += new_line

    open(fileName, "w").write(temp_buffer)


def fixPathRecursively(path):
    for root, dirs, files in os.walk(path):
        for file in files:
            ext = os.path.splitext(file)[-1]
            if ext == ".xml" or ext == ".java":
                refactorFile(root + "\\" + file)


def handleModule(moduleBaseFolder, codeFolder):
    print "Renaming " + moduleBaseFolder + codeFolder + srcPackage + " -> " + destPackage
    os.rename(moduleBaseFolder + codeFolder + srcPackage, moduleBaseFolder + codeFolder + destPackage)


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print "Usage: ChangePackageName.py [com.package_name1/com.package_name2]"
        sys.exit(0)
    if sys.argv[1] != "com.package_name1" and sys.argv[1] != "com.package_name2":
        print "Usage: ChangePackageName.py [com.package_name1/com.package_name2]"
        sys.exit(0)

    if sys.argv[1] == "com.package_name2":
        srcPackage = "package_name1"
        destPackage = "package_name2"
        appNameStringBefore = "<string name=\"app_name\">Project Name 1</string>"
        appNameString = "<string name=\"app_name\">Project Name 2</string>"
    else:
        srcPackage = "package_name2"
        destPackage = "package_name1"
        appNameStringBefore = "<string name=\"app_name\">Project Name 2</string>"
        appNameString = "<string name=\"app_name\">Project Name 1</string>"

    # The main thing, replaces the references inside all the xml and java files
    fixPathRecursively(basePath)

    # Doing some work on the modules' folders, like renaming folders to fit the new package name.
	# add/remove as needed
    try:
        handleModule(basePath + "\android-client\\", "src\com\\")
    except :
        print "Error renaming"
    try:
        handleModule(basePath + "\server-side\\", "src\\main\\java\\com\\")
    except :
        print "Error renaming"

		