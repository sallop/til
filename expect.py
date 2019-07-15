#!/usr/bin/python

import sys
import os
import traceback
import pexpect

sys.path.insert(0, os.getcwd())

child = pexpect.spawn('')
child.expect('')
child.sendline("""
{
    name : { value: ""},
    point: { value: "",
             validate: andValidate(
                p1Validate('node-input-point'),
                p6Validate('node-input-point'),
                p9Validate('node-input-point')
             ),
    },
    isValid: { value: false }
}
""")

def main():
    pass

if __name__ == "__main__":
    try:
        main()
    except Exception as e:
        print(str(e))
        TB_DUMP = traceback.format_exc()
        print(str(TB_DUMP))

